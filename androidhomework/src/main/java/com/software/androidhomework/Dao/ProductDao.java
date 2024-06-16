package com.software.androidhomework.Dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.software.androidhomework.entity.Product;
import com.software.androidhomework.entity.ProductInfo;
import com.software.androidhomework.entity.Result;
import com.software.androidhomework.entity.User;
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
    public static void getProducts(){
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

                    Result result = gson.fromJson(json,new TypeToken<Result<ProductInfo>>(){}.getType());

                    ProductInfo productInfo = (ProductInfo) result.getData();

                    for(Product product:productInfo.products){
                        products.add(product);
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
