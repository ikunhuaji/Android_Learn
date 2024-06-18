package com.software.androidhomework.Dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.software.androidhomework.entity.Result;
import com.software.androidhomework.entity.TotalBuy;
import com.software.androidhomework.entity.UserInfo;
import com.software.androidhomework.utils.HostUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class TotalBuyDao {
    public static List<TotalBuy>totalBuys = new ArrayList<>();

    //查找用户所有订单
    public static void getTotalBuys(String userName){
        totalBuys.clear();

        new Thread(){
            @Override
            public void run() {
                InputStream is = null;
                try {
                    URL url = new URL(HostUtil.HOST+"/totalBuy?userName="+userName);
                    is=url.openStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String json = br.readLine();
                    Gson gson = new Gson();

                    Result result = gson.fromJson(json,new TypeToken<Result<List<TotalBuy>>>(){}.getType());

                    List<TotalBuy>totalBuyList = (List<TotalBuy>) result.getData();

                    for (TotalBuy totalBuy:totalBuyList){
                        totalBuys.add(totalBuy);
                    }

                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public static void addTotalBuy(TotalBuy totalBuy){

        String userName = totalBuy.getUserName();
        String buyTime = totalBuy.getBuyTime();
        double totalPrice = totalBuy.getTotalPrice();

        new Thread(){
            @Override
            public void run() {
                InputStream is = null;
                try {
                    URL url = new URL(HostUtil.HOST+"/addTotalBuy?userName="+URLEncoder.encode(userName,"UTF-8")+"&buyTime="+ URLEncoder.encode(buyTime,"UTF-8") +"&totalPrice="+totalPrice);
                    is=url.openStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String json = br.readLine();
                    Gson gson = new Gson();

                    Result result = gson.fromJson(json,new TypeToken<Result<String>>(){}.getType());

                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }.start();

//        totalBuys.add(totalBuy);
    }
}
