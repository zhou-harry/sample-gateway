package com.harry.gateway.response;

import lombok.Builder;
import lombok.Data;

/**
 * @author harry
 * @version 1.0
 * @title: Response
 * @description: TODO
 * @date 2020/2/24 21:02
 */
@Data
@Builder
public class Response<T> {

    private int code;
    private String message;
    private T data;

    public static <T> Response<T> success(T data){
        return (Response<T>)Response.builder()
                .code(1)
                .message("请求成功")
                .data(data)
                .build();
    }

    public static <T> Response<T> fail(int code,String message){
        return (Response<T>)Response.builder()
                .code(code)
                .message(message)
                .build();
    }
}
