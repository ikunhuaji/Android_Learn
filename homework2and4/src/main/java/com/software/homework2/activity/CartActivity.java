package com.software.homework2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.software.homework2.Db.CartDb;
import com.software.homework2.R;
import com.software.homework2.adapters.CartAdapter;

public class CartActivity extends AppCompatActivity {

    private Button btn_cart_back;
    private TextView tv_cart_sumpay;
    private Button btn_cart_sumpay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        initViews();

        CartAdapter adapter = new CartAdapter(
                this,
                R.layout.item_cart
        );

        ListView lv_cart = findViewById(R.id.lv_cart);

        lv_cart.setAdapter(adapter);

        btn_cart_back.setOnClickListener(v->{
            Intent intent = new Intent(
                    CartActivity.this,
                    MainActivity.class
            );

            startActivity(intent);
        });

        btn_cart_sumpay.setOnClickListener(v->{
            double sum = CartDb.sumAll();
            tv_cart_sumpay.setText(String.valueOf(sum));
        });
    }

    private void initViews() {
        btn_cart_back = findViewById(R.id.btn_cart_back);
        tv_cart_sumpay = findViewById(R.id.tv_cart_sumpay);
        btn_cart_sumpay = findViewById(R.id.btn_cart_sumpay);
    }
}