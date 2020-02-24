package com.harry.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author harry
 * @version 1.0
 * @title: UserServerApp
 * @description: TODO
 * @date 2020/2/24 17:29
 */
@SpringBootApplication
@EnableDiscoveryClient
public class UserServerApp {
    public static void main(String[] args) {
        SpringApplication.run(UserServerApp.class, args);
    }
}
