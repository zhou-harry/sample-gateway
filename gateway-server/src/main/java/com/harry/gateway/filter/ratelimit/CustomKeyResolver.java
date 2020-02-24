package com.harry.gateway.filter.ratelimit;

import com.alibaba.fastjson.JSON;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 限流必须要有一个key，根据什么来进行限流，ip，接口，或者用户来进行限流，所以我们自定义一个KeyResolver
 * @author harry
 * @version 1.0
 * @title: CustomKeyResolver
 * @description: 限流
 * @date 2020/2/24 22:08
 */
public class CustomKeyResolver implements KeyResolver {

    public static final String BEAN_NAME = "customKeyResolver";

    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        return Mono.just(getKey(exchange));
    }

    /**
     *
     * @param exchange
     * @return
     */
    private String getKey(ServerWebExchange exchange) {

        LimitKey limitKey = LimitKey.builder()
                .api(exchange.getRequest().getPath().toString())
                .biz(exchange.getRequest().getQueryParams().getFirst("biz"))
                .build();

        return JSON.toJSONString(limitKey);
    }
}
