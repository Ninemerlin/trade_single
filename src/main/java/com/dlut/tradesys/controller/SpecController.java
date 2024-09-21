package com.dlut.tradesys.controller;

import com.dlut.tradesys.common.pojo.result.Result;
import com.dlut.tradesys.service.SpecService;
import com.dlut.tradesys.utils.UserContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/spec")
@RestController
@Slf4j
@RequiredArgsConstructor
public class SpecController {
    private final SpecService specService;

    @GetMapping("/getSpec")
    public Result getSpec(Integer itemId) {
        Long userId = UserContext.getUser();
        System.out.println("[SpecService] GetSpec : userId " + userId);
        Result result = specService.getSpec(itemId);
        if(result.getCode() == 200){
            System.out.println("[SpecService] GetSpec Succeeded.");
            return result;
        }
        System.out.println("[SpecService] GetSpec Failed.");
        return result;
    }

    @PostMapping("/addSpec")
    public Result addSpec(Integer itemId, String name) {
        Long userId = UserContext.getUser();
        System.out.println("[SpecService] AddSpec : userId " + userId);
        Result result = specService.addSpec(itemId, name);
        if(result.getCode() == 200){
            System.out.println("[SpecService] AddSpec Succeeded.");
            return result;
        }
        System.out.println("[SpecService] AddSpec Failed.");
        return result;
    }

    @DeleteMapping("/deleteSpec/{specId}")
    public Result deleteSpec(@PathVariable Integer specId) {
        Long userId = UserContext.getUser();
        System.out.println("[SpecService] DeleteSpec : userId " + userId);
        Result result = specService.deleteSpec(specId);
        if(result.getCode() == 200){
            System.out.println("[SpecService] DeleteSpec Succeeded.");
            return result;
        }
        System.out.println("[SpecService] DeleteSpec Failed.");
        return result;
    }
}
