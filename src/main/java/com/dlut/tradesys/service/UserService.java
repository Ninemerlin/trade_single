package com.dlut.tradesys.service;

import com.dlut.tradesys.common.pojo.result.Result;
import com.dlut.tradesys.common.pojo.User;

public interface UserService {
    Result login(User user);

    Result register(User user);

    Result cancel(Long userId);

    Result modifyIcon(String url);
}
