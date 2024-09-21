package com.dlut.tradesys.controller;

import com.dlut.tradesys.common.dto.TestFormDTO;
import com.dlut.tradesys.common.pojo.result.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
@Slf4j
@RequiredArgsConstructor
public class TestController {
    @PostMapping("/func")
    public Result test(@RequestBody TestFormDTO form){
        System.out.println(form.getName());
        System.out.println(form.getPassword());
        System.out.println(form.getList().toString());
        return Result.success();
    }
}
