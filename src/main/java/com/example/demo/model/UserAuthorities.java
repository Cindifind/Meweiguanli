package com.example.demo.model;

public class UserAuthorities {
    private int UserId;
    private int AuthorityId;

    public UserAuthorities() {
    }

    public UserAuthorities(int UserId, int AuthorityId) {
        this.UserId = UserId;
        this.AuthorityId = AuthorityId;
    }

    /**
     * 获取
     * @return UserId
     */
    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    /**
     * 获取
     * @return AuthorityId
     */
    public int getAuthorityId() {
        return AuthorityId;
    }

    /**
     * 设置
     * @param AuthorityId
     */
    public void setAuthorityId(int AuthorityId) {
        this.AuthorityId = AuthorityId;
    }

    public String toString() {
        return "UserAuthorities{UserId = " + UserId + ", AuthorityId = " + AuthorityId + "}";
    }
}
