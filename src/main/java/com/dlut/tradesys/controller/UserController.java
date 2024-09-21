package com.dlut.tradesys.controller;

import com.dlut.tradesys.common.pojo.result.Result;
import com.dlut.tradesys.common.pojo.User;
import com.dlut.tradesys.service.UserService;
import com.dlut.tradesys.utils.AliOSSUtils;
import com.dlut.tradesys.utils.UserContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping("/user")
@RestController
@Slf4j
@RequiredArgsConstructor
class UserController {
    private final UserService userService;
    private final AliOSSUtils aliOSSUtils;

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        System.out.println("[UserService] Login : " + user);
        Result result = userService.login(user);
        if(result.getCode() == 200){
            System.out.println("[UserService] Login Succeeded : " + result.getData().get("token"));
            return result;
        }
        System.out.println("[UserService] Login Failed.");
        return result;
    }

    @PostMapping("/register")
    public Result register(@RequestBody User user){
        System.out.println("[UserService] Register : " + user);
        Result result = userService.register(user);
        if(result.getCode() == 200){
            System.out.println("[UserService] Register Succeeded.");
            return result;
        }
        System.out.println("[UserService] Register Failed.");
        return result;
    }

    @DeleteMapping("/cancel")
    public Result cancel(){
        Long userId = UserContext.getUser();
        System.out.println("[UserService] CancelUser : " + userId);
        Result result = userService.cancel(userId);
        if(result.getCode() == 200){
            System.out.println("[UserService] Cancel Succeeded.");
            return result;
        }
        System.out.println("[UserService] Cancel Failed.");
        return result;
    }

    @PutMapping("/modifyIcon")
    public Result modifyIcon(MultipartFile image) throws IOException {
        System.out.println("[UserService] Image Modifying...");
        String url = aliOSSUtils.upload(image);
        Result result = userService.modifyIcon(url);
        if(result.getCode() == 200){
            System.out.println("[UserService] Image Modification Succeeded.");
            return result;
        }
        System.out.println("[UserService] Image Modification Failed.");
        return result;
    }
}
