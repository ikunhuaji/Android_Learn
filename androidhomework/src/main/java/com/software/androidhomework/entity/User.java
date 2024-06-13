package com.software.androidhomework.entity;

public class User {
    private String userName;
    private String pwd;
    private String email;
    private String storeName;
    private int id;

    public User(String userName, String pwd, String email, String storeName,int id) {
        this.userName = userName;
        this.pwd = pwd;
        this.email = email;
        this.storeName = storeName;
        this.id=id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
