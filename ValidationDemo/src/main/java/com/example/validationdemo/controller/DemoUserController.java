package com.example.validationdemo.controller;

import com.example.validationdemo.model.User;
import com.example.validationdemo.model.UserCreateGroup;
import com.example.validationdemo.model.UserUpdateGroup;
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
public class DemoUserController {

    @PostMapping(value = "/create")
    public String createUser(@RequestBody @Validated(UserCreateGroup.class) User user) {
        System.out.println("user:"+user);
        return "ok";
    }

    @PostMapping(value = "/update")
    public String updateUser(@RequestBody @Validated(UserUpdateGroup.class) User user) {
        System.out.println("user:"+user);
        return "ok";
    }
}
