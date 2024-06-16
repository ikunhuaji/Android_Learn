package com.software.androidhomework.entity;

public class User {
    private String userName;
    private String pwd;
    private String email;
    private String nickName;
    private int id;
    private String avatar;

    public User(String userName, String pwd, String email, String nickName,int id,String avatar) {
        this.userName = userName;
        this.pwd = pwd;
        this.email = email;
        this.nickName = nickName;
        this.id=id;
        this.avatar=avatar;
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
