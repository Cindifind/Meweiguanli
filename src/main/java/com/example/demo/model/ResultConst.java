package com.example.demo.model;

/**
 * 返回值常量类
 *
 * @author AfeiB
 * {@code @date}2024/10/26 下午12:32
 */

public enum ResultConst {
    LOGIN_SUCCESS(201, "登录成功"),
    PASSWORD_ERROR(301, "密码错误"),
    USER_NOT_EXIST(302, "用户不存在");

    /**
     * 枚举类的构造方法
     *
     * @param status  通过状态码对前端进行快速的判断
     * @param message 返回下消息描述
     */
    ResultConst(Integer status, String message) {
        new Result(status, message);
    }
}
