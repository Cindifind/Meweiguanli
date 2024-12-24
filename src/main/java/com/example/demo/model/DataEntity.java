package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "visitors")
public class DataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String departmentName;
    private String created_at;
    @Column(name = "carid")
    private String carId;
    private String nameID;
    private String name;
    private String phonenum;
    private String reason;
    private String request_at;
    private String openid;
    private String del;
    private int approve;

    public DataEntity() {
    }

    public DataEntity(Integer id, String departmentName, String created_at, String carId, String nameID, String name, String phonenum, String reason, String request_at, String openid, String del, int approve) {
        this.id = id;
        this.departmentName = departmentName;
        this.created_at = created_at;
        this.carId = carId;
        this.nameID = nameID;
        this.name = name;
        this.phonenum = phonenum;
        this.reason = reason;
        this.request_at = request_at;
        this.openid = openid;
        this.del = del;
        this.approve = approve;
    }

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     * @return departmentName
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * 设置
     * @param departmentName
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * 获取
     * @return created_at
     */
    public String getCreated_at() {
        return created_at;
    }

    /**
     * 设置
     * @param created_at
     */
    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    /**
     * 获取
     * @return carId
     */
    public String getCarId() {
        return carId;
    }

    /**
     * 设置
     * @param carId
     */
    public void setCarId(String carId) {
        this.carId = carId;
    }

    /**
     * 获取
     * @return nameID
     */
    public String getNameID() {
        return nameID;
    }

    /**
     * 设置
     * @param nameID
     */
    public void setNameID(String nameID) {
        this.nameID = nameID;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return phonenum
     */
    public String getPhonenum() {
        return phonenum;
    }

    /**
     * 设置
     * @param phonenum
     */
    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    /**
     * 获取
     * @return reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * 设置
     * @param reason
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * 获取
     * @return request_at
     */
    public String getRequest_at() {
        return request_at;
    }

    /**
     * 设置
     * @param request_at
     */
    public void setRequest_at(String request_at) {
        this.request_at = request_at;
    }

    /**
     * 获取
     * @return openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 设置
     * @param openid
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * 获取
     * @return del
     */
    public String getDel() {
        return del;
    }

    /**
     * 设置
     * @param del
     */
    public void setDel(String del) {
        this.del = del;
    }

    /**
     * 获取
     * @return approve
     */
    public int getApprove() {
        return approve;
    }

    /**
     * 设置
     * @param approve
     */
    public void setApprove(int approve) {
        this.approve = approve;
    }

    public String toString() {
        return "DataEntity{id = " + id + ", departmentName = " + departmentName + ", level = " + ", created_at = " + created_at + ", carId = " + carId + ", nameID = " + nameID + ", name = " + name + ", phonenum = " + phonenum + ", reason = " + reason + ", request_at = " + request_at + ", openid = " + openid + ", del = " + del + ", approve = " + approve + "}";
    }
}
