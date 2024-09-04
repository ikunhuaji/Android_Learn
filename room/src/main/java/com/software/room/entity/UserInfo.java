package com.software.room.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * 对应 user_info 表 ,通过 room 操作对象来操作表
 */

@Entity
public class UserInfo {
    //用于标识主键以及主键自增
    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private String name;
    private Integer age;
    private Integer height;
    private Float weight;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
