package com.software.androidhomework.entity;

public class Cart {
    private String userName;
    private String name;
    private double price;
    private int cnt;
    private String img;

    public Cart(String userName, String name, double price, int cnt, String img) {
        this.userName = userName;
        this.name = name;
        this.price = price;
        this.cnt = cnt;
        this.img = img;
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
}
