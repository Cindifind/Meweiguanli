package com.example.demo.model;

public enum Result {

    ADD_VISITOR_SUCCESS(202, "添加访客成功");
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

}
