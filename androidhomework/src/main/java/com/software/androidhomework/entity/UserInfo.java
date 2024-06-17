package com.software.androidhomework.entity;

public class UserInfo {
    private static String userName;
    private static String pwd;
    private static String email;
    private static String nickName;
    private static int id;
    private static String avatar;

    public static void update(User user) {
        UserInfo.userName = user.getUserName();
        UserInfo.pwd = user.getPwd();
        UserInfo.email = user.getEmail();
        UserInfo.nickName = user.getNickName();
        UserInfo.id=user.getId();
        UserInfo.avatar = user.getAvatar();
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        UserInfo.userName = userName;
    }

    public static String getPwd() {
        return pwd;
    }

    public static void setPwd(String pwd) {
        UserInfo.pwd = pwd;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        UserInfo.email = email;
    }

    public static String getNickName() {
        return nickName;
    }

    public static void setNickName(String nickName) {
        UserInfo.nickName = nickName;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        UserInfo.id = id;
    }

    public static String getAvatar() {
        return avatar;
    }

    public static void setAvatar(String avatar) {
        UserInfo.avatar = avatar;
    }
}
