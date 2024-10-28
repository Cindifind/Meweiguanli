package com.example.demo.model;

public class VisitorRequest {
    private String name;
    private String reason;
    private String carID;
    private String phonenum;


    public String getName() {
        return name;
    }

    public String getReason() {
        return reason;
    }

    public String getCarID() {
        return carID;
    }
    public  String getPhonenum() {
        return phonenum;
    }
    public String toString() {
        return "VisitorRequest{name = " + name + ", reason = " + reason + ", carID = " + carID + "}";
    }
}