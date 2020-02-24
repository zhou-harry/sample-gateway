package com.harry.gateway.filter.ratelimit;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.validation.Validator;

import java.util.List;

/**
 * @author harry
 * @version 1.0
 * @title: RateLimitConfig
 * @description: TODO
 * @date 2020/2/24 22:35
 */
@Configuration
public class RateLimitConfig {

    @Bean
    @Primary
    public CustomRedisRateLimiter customRedisRateLimiter(ReactiveRedisTemplate<String, String> redisTemplate,
                                                         @Qualifier(RedisRateLimiter.REDIS_SCRIPT_NAME) RedisScript<List<Long>> redisScript,
                                                         Validator validator) {
        return new CustomRedisRateLimiter(redisTemplate, redisScript, validator);
    }

    @Bean
    public RateLimiterGatewayFilterFactory rateLimiterGatewayFilterFactory(CustomRedisRateLimiter customRedisRateLimiter, CustomKeyResolver customKeyResolver) {
        return new RateLimiterGatewayFilterFactory(customRedisRateLimiter, customKeyResolver);
    }
}
