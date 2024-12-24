package com.example.demo.model;

public class AddUser {
    private String username;
    private String password;
    private String department_name;
    private String user;
    private int level;
    private int enabled;

    public AddUser() {
    }

    public AddUser(String username, String password, String department_name, String user, int level) {
        this.username = username;
        this.password = password;
        this.department_name = department_name;
        this.user = user;
        this.level = level;
        this.enabled = 1 ;
    }

    /**
     * 获取
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
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
     * @return user
     */
    public String getUser() {
        return user;
    }

    /**
     * 设置
     * @param user
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * 获取
     * @return level
     */
    public int getLevel() {
        return level;
    }

    /**
     * 设置
     * @param level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * 获取
     * @return enabled
     */
    public int getEnabled() {
        return enabled;
    }

    /**
     * 设置
     * @param enabled
     */
    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String toString() {
        return "AddUser{username = " + username + ", password = " + password + ", department_name = " + department_name + ", user = " + user + ", level = " + level + ", enabled = " + enabled + "}";
    }
}
