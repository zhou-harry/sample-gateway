package com.harry.gateway.route;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author harry
 * @version 1.0
 * @title: GatewayFilterDefinition
 * @description: 过滤器定义模型
 * @date 2020/2/24 22:27
 */
@Data
public class GatewayFilterDefinition {

    /**
     * Filter Name
     */
    private String name;

    /**
     * 对应的路由规则
     */
    private Map<String, String> args = new LinkedHashMap<>();

}
