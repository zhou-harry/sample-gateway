package com.harry.gateway.filter.ratelimit;

import lombok.Builder;
import lombok.Data;

/**
 * @author harry
 * @version 1.0
 * @title: LimitKey
 * @description: 限流
 * @date 2020/2/24 22:12
 */
@Data
@Builder
public class LimitKey {

    private String api;

    private String biz;
}
