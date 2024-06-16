package com.software.androidhomework.entity;

public class Product {
    private String name;
    private double price;
    private int nowCnt;
    private String img;

    public Product(String name, double price, int nowCnt, String img) {
        this.name = name;
        this.price = price;
        this.nowCnt = nowCnt;
        this.img = img;
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

    public int getNowCnt() {
        return nowCnt;
    }

    public void setNowCnt(int nowCnt) {
        this.nowCnt = nowCnt;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
