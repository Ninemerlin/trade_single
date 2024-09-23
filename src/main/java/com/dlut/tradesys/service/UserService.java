package com.dlut.tradesys.service;

import com.dlut.tradesys.common.dto.UserFormDTO;
import com.dlut.tradesys.common.pojo.result.Result;
import com.dlut.tradesys.common.pojo.User;

public interface UserService {
    Result login(User user);

    Result register(User user);

    Result cancel(Long userId);

    Result modifyIcon(Long userId, String url);

    Result getUser(Long userId);

    Result modifyUser(Long userId, UserFormDTO form);

    Result modifyMail(Long userId, String mail);

    Result modifyPwd(Long userId, String password);
}
