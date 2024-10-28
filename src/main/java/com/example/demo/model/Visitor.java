package com.example.demo.model;

import java.util.Date;

public class Visitor {
    private String name;
    private String reason;
    private String del;
    private String carID;
    private Date created_at;
    private String phonenum;

    public Visitor(String name, String reason ,String carID,String phonenum) {
        this.name = name;
        this.reason = reason;
        this.carID = carID;
        this.del = "0";
        this.created_at = new Date();
        this.phonenum = phonenum;

    }
    public String getCarID() {
        return carID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getReason() {
        return reason;
    }
    public String getDel() {
        return del;
    }
    public String getCreated_at() {
        return created_at.toString();
    }
    public String getPhonenum() {
        return phonenum;
    }
}