package com.example.demo.model;

/**
 * 返回值常量类
 *
 * @author AfeiB
 * {@code @date}2024/10/26 下午12:32
 */

public enum Result {
    LOGIN_SUCCESS(201, "登录成功"),
    ADD_VISITOR_SUCCESS(202, "添加访客成功"),
    REMOVE_VISITOR_SUCCESS(203, "删除访客成功"),
    BATCH_REMOVE_VISITOR_SUCCESS(204, "批量删除访客成功"),
    QUERY_VISITOR_SUCCESS(205, "查询访客成功"),
    BATCH_QUERY_VISITOR_SUCCESS(206, "批量查询访客成功"),


    //错误常量
    PASSWORD_ERROR(301, "密码错误"),
    VISITOR_NOT_EXIST_ERROR(302, "访客不存在"),
    REMOVE_VISITOR_ERROR(303, "删除访客失败,访客可能不存在"),
    ;

    private final Integer status;
    private final String message;
    private Object object;

    /**
     * 枚举类的构造方法
     *
     * @param status  通过状态码对前端进行快速的判断
     * @param message 返回下消息描述
     */
    Result(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Object getObject() {
        return object;
    }

    /**
     * @param object 传入对象，给返回值用
     * @return 返回当前常量
     */
    public Result setObject(Object object) {
        this.object = object;
        return this;
    }
}
