package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "department")
public class department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String department_name;
    private int level; // 修改为 int 类型

    public department() {
    }

    public department(String department_name, int level) { // 修改构造函数参数类型
        this.department_name = department_name;
        this.level = level;
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
     * @return department_name
     */
    public String getDepartment_name() {
        return department_name;
    }

    /**
     * 设置
     * @param department_name
     */
    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    /**
     * 获取
     * @return level
     */
    public int getLevel() { // 修改返回类型
        return level;
    }

    /**
     * 设置
     * @param level
     */
    public void setLevel(int level) { // 修改参数类型
        this.level = level;
    }

    public String toString() {
        return "department{id = " + id + ", department_name = " + department_name + ", level = " + level + "}";
    }
}
