package com.software.androidhomework.entity;

import java.io.Serializable;

public class TotalBuy implements Serializable {
    private String userName;
    private String buyTime;
    private double totalPrice;

    public TotalBuy(String userName, String buyTime, double totalPrice) {
        this.userName = userName;
        this.buyTime = buyTime;
        this.totalPrice = totalPrice;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String buyTime) {
        this.buyTime = buyTime;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
