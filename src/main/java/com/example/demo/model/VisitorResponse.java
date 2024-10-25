package com.example.demo.model;

public class VisitorResponse {
    private String status;
    private String message;
    private Visitor data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Visitor getData() {
        return data;
    }

    public void setData(Visitor data) {
        this.data = data;
    }
}