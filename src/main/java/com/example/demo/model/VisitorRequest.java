package com.example.demo.model;

public class VisitorRequest {
    private String name;
    private String reason;
    private String carID;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * 获取
     * @return carID
     */
    public String getCarID() {
        return carID;
    }

    /**
     * 设置
     * @param carID
     */
    public void setCarID(String carID) {
        this.carID = carID;
    }

    public String toString() {
        return "VisitorRequest{name = " + name + ", reason = " + reason + ", carID = " + carID + "}";
    }
}