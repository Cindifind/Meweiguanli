package com.example.demo.model;

import java.util.Date;

public class Visitor {
    private String name;
    private String reason;
    private String del;
    private String carID;

    private Date created_at;

    public Visitor(String name, String reason ,String carID) {
        this.name = name;
        this.reason = reason;
        this.carID = carID;
        this.del = "0";
        this.created_at = new Date();
    }
    public String getCarID() {
        return carID;
    }
    public void setCarID(String carID) {
        this.carID = carID;
    }public String getName() {
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

    public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del;
    }




    public String getCreated_at() {
        return created_at.toString();
    }
    @Override
    public String toString() {
        return "Visitor{" +
                "name='" + name + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}