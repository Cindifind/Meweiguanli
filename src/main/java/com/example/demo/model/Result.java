package com.example.demo.model;

public enum Result {
    SUCCESS(200, "操作成功", null),
    FAIL(400, "操作失败", null),
    NOT_FOUND(404, "资源不存在", null),
    UNAUTHORIZED(401, "用户未登录", null),
    FORBIDDEN(403, "用户无权限", null),
    NOT_IMPLEMENTED(501, "接口未实现", null),
    SERVER_ERROR(500, "服务器错误", null),
    USERNAME_EXISTS(409, "用户名已存在", null); // 新增枚举值

    private final Integer status;
    private final String message;
    private final Object object;

    Result(Integer status, String message, Object object) {
        this.status = status;
        this.message = message;
        this.object = object;
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

    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", object=" + object +
                '}';
    }

    public static Result fromStatus(Integer status) {
        for (Result result : Result.values()) {
            if (result.getStatus().equals(status)) {
                return result;
            }
        }
        return null;
    }
}
