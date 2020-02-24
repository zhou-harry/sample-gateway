package com.harry.gateway.route;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author harry
 * @version 1.0
 * @title: GatewayPredicateDefinition
 * @description: 路由断言定义模型
 * @date 2020/2/24 22:27
 */
@Data
public class GatewayPredicateDefinition {

    /**
     * 断言对应的Name
     */
    private String name;

    /**
     * 配置的断言规则
     */
    private Map<String, String> args = new LinkedHashMap<>();

}
