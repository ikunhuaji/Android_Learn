package com.software.androidhomework.entity;

public class NowUser {
    public static String userName;
    public static String pwd;
    public static String email;
    public static String nickName;

    public static int id;
    public static String avatar;

    public void update(User user) {
        this.userName = user.getUserName();
        this.pwd = user.getPwd();
        this.email = user.getEmail();
        this.nickName = user.getNickName();
        this.id=user.getId();
        this.avatar = user.getAvatar();
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

    public static String getAvatar() {
        return avatar;
    }

    public static void setAvatar(String avatar) {
        NowUser.avatar = avatar;
    }
}
