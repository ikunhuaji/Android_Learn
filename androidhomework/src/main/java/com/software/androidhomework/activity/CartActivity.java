package com.software.androidhomework.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.software.androidhomework.Dao.BuyDao;
import com.software.androidhomework.Dao.CartDao;
import com.software.androidhomework.Dao.ProductDao;
import com.software.androidhomework.Dao.TotalBuyDao;
import com.software.androidhomework.R;
import com.software.androidhomework.adapters.CartAdapter;
import com.software.androidhomework.entity.Buy;
import com.software.androidhomework.entity.Cart;
import com.software.androidhomework.entity.Product;
import com.software.androidhomework.entity.TotalBuy;
import com.software.androidhomework.entity.UserInfo;
import com.software.androidhomework.utils.DateMethod;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    private ListView lv_cart;
    private Button btn_cart_sumpay;
    private Button btn_cart_pay;
    private TextView tv_cart_sumpay;
    private Button btn_cart_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        initViews();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                CartDao.getCarts(UserInfo.getUserName());
            }
        });

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        CartAdapter adapter = new CartAdapter(
            this,
                R.layout.item_cart
        );

        lv_cart.setAdapter(adapter);

        initEvents();
    }

    private void initEvents() {

        btn_cart_back.setOnClickListener(v->{
            Intent intent = new Intent(
                    CartActivity.this,
                    ShopActivity.class
            );

            startActivity(intent);
        });

        //计算总价
        btn_cart_sumpay.setOnClickListener(v->{
            double sum = CartDao.sumAll();
            tv_cart_sumpay.setText(String.valueOf(sum));
        });

        //购买 并判定存货
        btn_cart_pay.setOnClickListener(v->{

            //更新本地信息 比较库存
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    ProductDao.getProducts();
                    TotalBuyDao.getTotalBuys(UserInfo.getUserName());
                }
            });

            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //添加时间等待线程更新
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean fg=true;
            for(Cart cart:CartDao.carts){
                for(Product product:ProductDao.products){
                    if(cart.getName().equals(product.getName())){
                        if(cart.getCnt()<=product.getNowCnt())break;
                        else
                        {
                            fg = false;
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    //普通对话框
                                    AlertDialog dialog = new AlertDialog.Builder(CartActivity.this)
                                            .setMessage(cart.getName()+"存货只剩下 "+product.getNowCnt()+" 件")//设置对话框的内容
                                            .create();
                                    dialog.show();
                                }
                            });

                            break;
                        }
                    }
                }
                if(!fg)break;
            }

            //carts与数据库cart清空 更新订单数据 返回主页
            if(fg){

                double totalPrice = CartDao.sumAll();
                String buyTime = DateMethod.getDate();
                String username = UserInfo.getUserName();

                if(totalPrice>0){
                    thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            TotalBuyDao.addTotalBuy(new TotalBuy(username,buyTime,totalPrice));
                        }
                    });
                    thread.start();
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //提交订单详情
                    for(Cart cart:CartDao.carts){
                        thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                BuyDao.addBuy(new Buy(cart.getUserName(),cart.getName(),cart.getPrice(),cart.getCnt(),cart.getImg(),buyTime));
                            }
                        });
                        thread.start();
                        try {
                            thread.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    //清空购物车
                    thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            CartDao.clear(UserInfo.getUserName());
                        }
                    });
                    thread.start();
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(
                                CartActivity.this,
                                "购买成功",
                                Toast.LENGTH_SHORT
                        ).show();
                    }
                });

                //跳转
                Intent intent = new Intent(
                        CartActivity.this,
                        ShopActivity.class
                );

                startActivity(intent);
            }
        });
    }

    private void initViews() {
        lv_cart = findViewById(R.id.lv_cart);
        btn_cart_sumpay = findViewById(R.id.btn_cart_sumpay);
        tv_cart_sumpay = findViewById(R.id.tv_cart_sumpay);
        btn_cart_pay = findViewById(R.id.btn_cart_pay);
        btn_cart_back = findViewById(R.id.btn_cart_back);
    }
}