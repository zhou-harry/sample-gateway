package com.harry.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author harry
 * @version 1.0
 * @title: UserController
 * @description: TODO
 * @date 2020/2/24 17:33
 */
@RestController
@RequestMapping("user")
public class UserController {


    @GetMapping("hello")
    public String sayHello(String name) {
        return "hello," + name;
    }
}
