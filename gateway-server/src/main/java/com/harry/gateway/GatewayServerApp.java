package com.harry.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author harry
 * @version 1.0
 * @title: GatewayServerApp
 * @description: TODO
 * @date 2020/2/24 18:06
 */
@SpringCloudApplication
public class GatewayServerApp {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServerApp.class, args);
    }

}
