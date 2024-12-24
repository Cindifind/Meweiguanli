package com.example.demo.model;

import java.util.Date;

public class Visitor {
    private String name;
    private final String reason;
    private final String del;
    private final String carID;
    private final Date created_at;
    private final String phonenum;
    private final String nameId;
    private final String request_at;
    private final String department_name;
    private final String openid;
    private final int approve;

    public Visitor(String name, String reason , String carID, String phonenum, String nameId, String request_at, String department_name, String openid) {
        this.name = name;
        this.reason = reason;
        this.carID = carID;
        this.del = "0";
        this.created_at = new Date();
        this.phonenum = phonenum;
        this.nameId = nameId;
        this.request_at = request_at;
        this.department_name = department_name;
        this.openid = openid;
        this.approve = 0;
    }
    public int getApprove() {
        return approve;
    }
    public String getRequest_at() {
        return request_at;
    }
    public String getDepartment_name() {
        return department_name;
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
    public String getOpenid() {
        return openid;
    }
}