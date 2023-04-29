package com.example.validationdemo.model;

import jakarta.validation.constraints.NotNull;

/**
 * @author fking
 * @date 2023-04-30 00:16
 */
public class User {
    @NotNull(message = "id不能为空", groups = {UserUpdateGroup.class})
    private String id;

    @NotNull(message = "用户名不能为空", groups = {UserCreateGroup.class, UserUpdateGroup.class})
    private String username;
}
