package com.harry.gateway.fallback;

import com.harry.gateway.response.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author harry
 * @version 1.0
 * @title: FallbackController
 * @description: 熔断
 * @date 2020/2/24 22:17
 */
@RestController
public class FallbackController {
    @GetMapping("/fallback")
    public Response fallback() {
        return Response.fail(400,"服务暂时无响应");
    }
}
