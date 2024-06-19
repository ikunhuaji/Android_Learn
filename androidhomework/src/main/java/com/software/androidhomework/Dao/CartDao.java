package com.software.androidhomework.Dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.software.androidhomework.entity.Cart;
import com.software.androidhomework.entity.Result;
import com.software.androidhomework.utils.HostUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class CartDao {
    public static List<Cart>carts = new ArrayList<>();

    public static void getCarts(String userName){
        carts.clear();
        new Thread(){
            @Override
            public void run() {
                InputStream is = null;
                try {
                    URL url = new URL(HostUtil.HOST+"/cart?userName="+userName);
                    is = url.openStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String json = br.readLine();
                    Gson gson = new Gson();
                    Result result = gson.fromJson(json,new TypeToken<Result<List<Cart>>>(){}.getType());

                    List<Cart>cartList = (List<Cart>) result.getData();

                    for(Cart cart:cartList){
                        carts.add(cart);
                    }

                    carts.size();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }.start();
    }

    //购物车添加商品
    public static void addCart(Cart cart){
        String userName = cart.getUserName();
        String name = cart.getName();
        double price = cart.getPrice();
        int cnt = cart.getCnt();
        String img = cart.getImg();

        new Thread(){
            @Override
            public void run() {
                InputStream is = null;
                try {
                    URL url = new URL(HostUtil.HOST+"/addCart?userName="+userName+"&name="+name+"&price="+price+"&cnt="+cnt+"&img="+ URLEncoder.encode(img,"UTF-8"));
                    is = url.openStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String json = br.readLine();
                    Gson gson = new Gson();
                    Result result = gson.fromJson(json,new TypeToken<Result<String>>(){}.getType());

                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public static void addCartCnt(Cart cart){
        String userName = cart.getUserName();
        String name = cart.getName();

        new Thread(){
            @Override
            public void run() {
                InputStream is = null;
                try {
                    URL url = new URL(HostUtil.HOST+"/addCartCnt?userName="+userName+"&name="+name);
                    is = url.openStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String json = br.readLine();
                    Gson gson = new Gson();

                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public static void reduceCartCnt(Cart cart){
        String userName = cart.getUserName();
        String name = cart.getName();

        new Thread(){
            @Override
            public void run() {
                InputStream is = null;
                try {
                    URL url = new URL(HostUtil.HOST+"/reduceCartCnt?userName="+userName+"&name="+name);
                    is = url.openStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String json = br.readLine();
                    Gson gson = new Gson();

                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public static void deleteCart(String userName,String name){
        new Thread(){
            @Override
            public void run() {
                InputStream is = null;
                try {
                    URL url = new URL(HostUtil.HOST+"/deleteCart?userName="+userName+"&name="+name);
                    is = url.openStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String json = br.readLine();
                    Gson gson = new Gson();

                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public static void clear(String userName){
        carts.clear();
        new Thread(){
            @Override
            public void run() {
                InputStream is = null;
                try {
                    URL url = new URL(HostUtil.HOST+"/clearCart?userName="+userName);
                    is = url.openStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String json = br.readLine();
                    Gson gson = new Gson();

                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public static double sumAll() {
        double sum = 0;

        for(Cart cart : carts){
            sum+=cart.getCnt()*cart.getPrice();
        }

        return sum;
    }

    public static void delete(Cart cart) {
        String name = cart.getName();
        for(int i=0;i<carts.size();i++){
            if(carts.get(i).getName().equals(name)){
                carts.remove(i);
                break;
            }
        }
    }
}
