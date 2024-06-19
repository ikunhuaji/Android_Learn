package com.software.androidhomework.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.software.androidhomework.Dao.CartDao;
import com.software.androidhomework.R;
import com.software.androidhomework.adapters.CartAdapter;
import com.software.androidhomework.entity.UserInfo;

import java.util.List;

public class CartActivity extends AppCompatActivity {

    private ListView lv_cart;
    private List carts;
    private Button btn_cart_sumpay;
    private Button btn_cart_pay;
    private TextView tv_cart_sumpay;

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

        initEvents();

        CartAdapter adapter = new CartAdapter(
            this,
                R.layout.item_cart
        );
    }

    private void initEvents() {
        //计算总价
        btn_cart_sumpay.setOnClickListener(v->{

        });

        //购买 并判定存货
        btn_cart_pay.setOnClickListener(v->{

        });
    }

    private void initViews() {
        lv_cart = findViewById(R.id.lv_cart);
        btn_cart_sumpay = findViewById(R.id.btn_cart_sumpay);
        tv_cart_sumpay = findViewById(R.id.tv_cart_sumpay);
        btn_cart_pay = findViewById(R.id.btn_cart_pay);
    }
}