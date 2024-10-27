package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="visitors")
public class DataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer del;
    private String reason;
    private String created_at;
    private Integer GA;
    private Integer OAAA;

    public DataEntity() {
    }

    public DataEntity(Integer id, String name, Integer del, String reason, String created_at, Integer GA, Integer OAAA) {
        this.id = id;
        this.name = name;
        this.del = del;
        this.reason = reason;
        this.created_at = created_at;
        this.GA = GA;
        this.OAAA = OAAA;
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
     * @return del
     */
    public Integer getDel() {
        return del;
    }

    /**
     * 设置
     * @param del
     */
    public void setDel(Integer del) {
        this.del = del;
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
     * @return GA
     */
    public Integer getGA() {
        return GA;
    }

    /**
     * 设置
     * @param GA
     */
    public void setGA(Integer GA) {
        this.GA = GA;
    }

    /**
     * 获取
     * @return OAAA
     */
    public Integer getOAAA() {
        return OAAA;
    }

    /**
     * 设置
     * @param OAAA
     */
    public void setOAAA(Integer OAAA) {
        this.OAAA = OAAA;
    }

    public String toString() {
        return "DataEntity{id = " + id + ", name = " + name + ", del = " + del + ", reason = " + reason + ", created_at = " + created_at + ", GA = " + GA + ", OAAA = " + OAAA + "}";
    }

    // Getters and Setters

}