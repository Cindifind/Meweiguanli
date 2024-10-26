package com.example.demo.model;

/**
 * 返回结果类，用户返回请求的结果，搭配枚举使用
 *
 * @author AfeiB
 * {@code @date} 2024/10/25 下午8:17
 */

public class Result {
    /**
     * 返回的状态码
     */
    Integer status;
    /**
     * 返回消息
     */
    String message;
    /**
     * 返回的对象
     */
    Object data;

    public Result(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Result(Integer status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
