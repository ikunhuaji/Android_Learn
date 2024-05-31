package com.software.homework2.entity;

import java.io.Serializable;

public class Product implements Serializable {

    private Integer image;
    private String name;
    private String intro;
    private Double price;

    public Product(Integer image, String name, String intro, Double price) {
        this.image = image;
        this.name = name;
        this.intro = intro;
        this.price = price;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
