package com.dlut.tradesys.service.impl;

import com.dlut.tradesys.common.enums.UserStatus;
import com.dlut.tradesys.common.pojo.result.Result;
import com.dlut.tradesys.common.pojo.User;
import com.dlut.tradesys.mapper.UserMapper;
import com.dlut.tradesys.service.UserService;
import com.dlut.tradesys.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Override
    public Result login(User user) {
        // 1.查询用户
        String username = user.getUsername();
        String password = user.getPassword();
        User u = userMapper.getUserByUsername(username);
        if(u == null) {
            return Result.fail().addMsg("用户不存在.");
        }
        // 2.校验是否禁用
        if (user.getStatus() == UserStatus.FROZEN) {
            return Result.fail().addMsg("用户被冻结.");
        }
        // 3.校验密码
        if (!password.equals(u.getPassword())) {
            System.out.println(password);
            System.out.println(user.getPassword());
            return Result.fail().addMsg("密码错误.");
        }
        // 4.生成TOKEN
        Map<String, Object> claims = new HashMap<>();
        claims.put("id",u.getId());
        claims.put("name",u.getUsername());
        String jwt = JwtUtil.generateJwt(claims);
        return Result.success().addMsg("登录成功.").addData("token",jwt);
    }

    @Override
    public Result register(User user) {
        if(userMapper.getUserByUsername(user.getUsername()) != null) {
            return Result.fail().addMsg("用户已存在.");
        }
        user.setPassword(user.getPassword()); // 暂不加密
        user.setStatus(UserStatus.NORMAL);
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        if(userMapper.addUser(user)) {
            return Result.success().addMsg("用户 "+ user.getUsername() + " 注册成功.");
        }
        return Result.fail().addMsg("用户 "+ user.getUsername() + " 注册失败.");
    }

    @Override
    public Result cancel(Long userId) {
        if(userMapper.cancel(userId)) {
            // 关联数据库的信息删除 暂空

            return Result.success().addMsg("注销成功.");
        }
        return Result.fail().addMsg("注销失败.");
    }
}
