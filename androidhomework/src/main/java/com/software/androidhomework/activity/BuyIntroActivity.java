package com.software.androidhomework.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.software.androidhomework.Dao.BuyDao;
import com.software.androidhomework.R;
import com.software.androidhomework.adapters.BuyIntroAdapter;
import com.software.androidhomework.entity.Buy;
import com.software.androidhomework.entity.TotalBuy;
import com.software.androidhomework.entity.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class BuyIntroActivity extends AppCompatActivity {

    private ListView lv_buy;
    private TextView tv_buy_totalPrice;
    private Intent intent;
    private Bundle bundle;
    private List<Buy> buys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_intro);

        intent = getIntent();
        bundle = intent.getExtras();
        TotalBuy totalBuy = (TotalBuy)bundle.getSerializable("totalBuy");

        buys = BuyDao.buys;

        double totalPrice = totalBuy.getTotalPrice();

        initViews();

        tv_buy_totalPrice.setText(String.valueOf(totalPrice));

        BuyIntroAdapter adapter = new BuyIntroAdapter(
                this,
                R.layout.item_buy,
                buys
        );

        lv_buy.setAdapter(adapter);
    }

    private void initViews() {
        lv_buy = findViewById(R.id.lv_buy);
        tv_buy_totalPrice = findViewById(R.id.tv_buy_totalPrice);
    }
}