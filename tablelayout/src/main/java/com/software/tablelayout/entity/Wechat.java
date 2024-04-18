package com.software.tablelayout.entity;

import com.software.tablelayout.R;

import java.util.ArrayList;
import java.util.List;

public class Wechat {
    private Integer avatar;
    private String nickname;
    private String endMessage;


    public Wechat(){}

    public Wechat(Integer avatar,String nickname,String endMessage){
        this.avatar=avatar;
        this.nickname=nickname;
        this.endMessage=endMessage;
    }

    //模拟聊天数据
    public static List<Wechat> getWechatList(){
        List<Wechat>wechatList = new ArrayList<>();
        wechatList.add(new Wechat(R.mipmap.avatar1,"number1","KFC"));
        wechatList.add(new Wechat(R.mipmap.avatar2,"number2","CRAZY THURSDAY"));
        wechatList.add(new Wechat(R.mipmap.avatar3,"number3","VIVO 50"));
        return wechatList;
    }

    public Integer getAvatar() {
        return avatar;
    }

    public void setAvatar(Integer avatar) {
        this.avatar = avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEndMessage() {
        return endMessage;
    }

    public void setEndMessage(String endMessage) {
        this.endMessage = endMessage;
    }
}
