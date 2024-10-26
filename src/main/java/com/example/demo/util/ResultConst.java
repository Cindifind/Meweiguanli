package com.example.demo.util;

public class ResultConst {

    private boolean success;
    private String message;

    private ResultConst(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public static ResultConst success() {
        return new ResultConst(true, "操作成功");
    }

    public static ResultConst failure(String message) {
        return new ResultConst(false, message);
    }

    // Getters and Setters
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
