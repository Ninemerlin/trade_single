package com.dlut.tradesys.service.impl;

import com.dlut.tradesys.common.dto.UserFormDTO;
import com.dlut.tradesys.common.enums.UserStatus;
import com.dlut.tradesys.common.pojo.result.Result;
import com.dlut.tradesys.common.pojo.User;
import com.dlut.tradesys.mapper.UserMapper;
import com.dlut.tradesys.service.UserService;
import com.dlut.tradesys.utils.JwtUtil;
import com.dlut.tradesys.utils.UserContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
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
        u.setPassword(null);
        return Result.success().addMsg("登录成功.").addData("token",jwt).addData("user",u);
    }

    @Override
    public Result register(User user) {
        if(userMapper.getUserByUsername(user.getUsername()) != null) {
            return Result.fail().addMsg("用户已存在.");
        }
        if(user.getUserType() == 3) {
            return Result.fail().addMsg("不可注册管理员.");
        }
        user.setPassword(user.getPassword()); // 暂不加密
        user.setNickname(user.getUsername());
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

    @Override
    public Result modifyIcon(Long userId, String url) {
        if(userMapper.modifyIconPath(userId, url)) {
            return Result.success().addMsg("头像修改成功.");
        }
        return Result.fail().addMsg("头像修改失败.");
    }

    @Override
    public Result getUser(Long userId) {
        User u = userMapper.getUserById(userId);
        if(u != null) {
            return Result.success().addMsg("用户 "+ u.getUsername() + " 查询成功.").addData("user",u);
        }
        return Result.fail().addMsg("用户查询失败.");
    }

    @Override
    public Result modifyUser(Long userId, UserFormDTO form) {
        // 因为根据前端设计UserFormDTO可能有变动所以用反射
        Field[] fields = UserFormDTO.class.getDeclaredFields();
        for(Field f : fields) {
            f.setAccessible(true);
            try {
                if(!userMapper.setAttribute(userId, f.getName(), f.get(form))){
                    return Result.fail().addMsg("用户信息更新失败.");
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return Result.success().addMsg("用户信息更新成功.");
    }

    @Override
    public Result modifyMail(Long userId, String mail) {
        if(userMapper.modifyMail(userId, mail)) {
            return Result.success().addMsg("邮箱修改成功.");
        }
        return Result.fail().addMsg("邮箱修改失败.");
    }

    @Override
    public Result modifyPwd(Long userId, String password) {
        if(userMapper.modifyPwd(userId, password)) {
            return Result.success().addMsg("密码修改成功.");
        }
        return Result.fail().addMsg("密码修改失败.");
    }
}
