package com.software.homework2.Db;

import com.software.homework2.entity.BuyItem;
import com.software.homework2.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class CartDb {
    public static List<BuyItem> cartList = new ArrayList<>();

    public static int add(Product product,int cnt){
        boolean fg=false;
        for(int i = 0; i< cartList.size(); i++){
            if(cartList.get(i).product.getName().equals(product.getName())){
                cartList.get(i).cnt+=cnt;
                fg=true;
                return cartList.get(i).cnt;
            }
        }

        if(!fg){
            //找不到 新增产品
            BuyItem buyItem = new BuyItem(product,cnt);
            cartList.add(buyItem);

        }

        return cnt;
    }

    public static int reduce(Product product){
        for(int i = 0; i< cartList.size(); i++){
            if(cartList.get(i).product.getName().equals(product.getName())){
                cartList.get(i).cnt--;
                return cartList.get(i).cnt;
            }
        }

        return 0;
    }

    public static void delete(Product product){
        for(int i = 0; i< cartList.size(); i++){
            if(cartList.get(i).product.getName().equals(product.getName())){
                cartList.remove(i);
                return;
            }
        }
    }

    public static int findCnt(Product product){
        for(int i = 0; i< cartList.size(); i++){
            if(cartList.get(i).product.getName().equals(product.getName())){
                return cartList.get(i).cnt;
            }
        }
        return 0;
    }

    public static double sumAll(){
        double sum=0;

        for(BuyItem it: cartList){
            if(it.cnt>0){
                sum+=it.cnt*it.product.getPrice();
            }
        }

        return sum;
    }
}
