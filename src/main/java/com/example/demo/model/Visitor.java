package com.example.demo.model;

import java.util.Date;

public class Visitor {
    private String name;
    private String reason;
    private String del;
    private String carID;
    private Date created_at;
    private String phonenum;
    private String nameId;
    private String request_at;
    private String college;

    public Visitor(String name, String reason ,String carID,String phonenum,String nameId,String request_at,String college) {
        this.name = name;
        this.reason = reason;
        this.carID = carID;
        this.del = "0";
        this.created_at = new Date();
        this.phonenum = phonenum;
        this.nameId = nameId;
        this.request_at = request_at;
        this.college = college;
    }
    public String getRequest_at() {
        return request_at;
    }
    public String getCollege() {
        return college;
    }
    public String getNameId() {
        return nameId;
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