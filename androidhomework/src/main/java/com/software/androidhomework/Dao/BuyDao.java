package com.software.androidhomework.Dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.software.androidhomework.entity.Buy;
import com.software.androidhomework.entity.Result;
import com.software.androidhomework.utils.HostUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BuyDao {
    public static List<Buy> buys = new ArrayList<>();

    //查找特定时间订单内商品详情
    public static List<Buy> getBuys(String userName,String buyTime){
        buys.clear();
        new Thread(){
            @Override
            public void run() {
                InputStream is = null;
                try {
                    URL url = new URL(HostUtil.HOST+"/buy?userName"+userName+"&buyTime="+buyTime);
                    is=url.openStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String json = br.readLine();
                    Gson gson = new Gson();

                    Result result = gson.fromJson(json,new TypeToken<Result<List<Buy>>>(){}.getType());

                    List<Buy>buyList = (List<Buy>) result.getData();

                    for(Buy buy:buyList){
                        buys.add(buy);
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }.start();

        return buys;
    }


}
