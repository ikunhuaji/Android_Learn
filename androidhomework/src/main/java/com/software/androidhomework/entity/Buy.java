package com.software.androidhomework.entity;

public class Buy {
    private String userName;//用户名
    private String name;//商品名
    private double price;//单价
    private int cnt;
    private String img;
    private String buyTime;

    public Buy(String userName, String name, double price, int cnt, String img, String buyTime) {
        this.userName = userName;
        this.name = name;
        this.price = price;
        this.cnt = cnt;
        this.img = img;
        this.buyTime = buyTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String buyTime) {
        this.buyTime = buyTime;
    }
}
