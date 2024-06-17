package com.software.androidhomework.Dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.software.androidhomework.entity.Product;
import com.software.androidhomework.entity.Result;
import com.software.androidhomework.utils.HostUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    public static List<Product>products = new ArrayList<>();

    //获取商品存货
    public static List<Product> getProducts(){
        products.clear();
        new Thread(){
            @Override
            public void run() {
                InputStream is = null;
                try {
                    URL url = new URL(HostUtil.HOST+"/product");
                    is=url.openStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String json = br.readLine();
                    Gson gson = new Gson();
                    Result result = gson.fromJson(json,new TypeToken<Result<List<Product>>>(){}.getType());

                    List<Product>productList = (List<Product>) result.getData();

                    for(Product product:productList){
                        products.add(product);
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }.start();

        return products;
    }

    //增加商品存货
    public static void addProduct(Product product,int cnt){
        products.clear();
        new Thread(){
            @Override
            public void run() {
                String name = product.getName();

                InputStream is = null;
                try {
                    URL url = new URL(HostUtil.HOST+"/addProduct?name="+name+"&cnt="+cnt);
                    is=url.openStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String json = br.readLine();
                    Gson gson = new Gson();
                    Result result = gson.fromJson(json,new TypeToken<Result<List<Product>>>(){}.getType());

                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public static void reduceProduct(Product product,int cnt){
        products.clear();

        new Thread(){
            @Override
            public void run() {
                String name = product.getName();
                InputStream is = null;
                try {
                    URL url = new URL(HostUtil.HOST+"/reduceProduct?name="+name+"&cnt="+cnt);
                    is=url.openStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String json = br.readLine();
                    Gson gson = new Gson();
                    Result result = gson.fromJson(json,new TypeToken<Result<List<Product>>>(){}.getType());

                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
