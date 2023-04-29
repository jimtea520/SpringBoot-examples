package com.example.validationdemo.controller;

import com.example.validationdemo.model.VerificationLoginDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fking
 * @date 2023-04-29 18:47
 */
@RequestMapping("/api/user")
@RestController
@Slf4j
public class DemoController {

    @PostMapping(value = "/loginByCode")
    public String loginByCode(@RequestBody(required = false) @Validated VerificationLoginDto dto) {
        System.out.println("dto:"+dto);
        return "ok";
    }
}
