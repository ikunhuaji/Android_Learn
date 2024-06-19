package com.software.androidhomework.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.software.androidhomework.Dao.BuyDao;
import com.software.androidhomework.Dao.CartDao;
import com.software.androidhomework.Dao.ProductDao;
import com.software.androidhomework.Dao.TotalBuyDao;
import com.software.androidhomework.R;
import com.software.androidhomework.entity.Buy;
import com.software.androidhomework.entity.Cart;
import com.software.androidhomework.entity.Product;
import com.software.androidhomework.entity.TotalBuy;
import com.software.androidhomework.entity.UserInfo;
import com.software.androidhomework.utils.DateMethod;

public class IntroActivity extends AppCompatActivity {

    private ImageView iv_intro_img;
    private TextView tv_intor_name;
    private TextView tv_intro_nowCnt;
    private TextView tv_intro_price;
    private Button btn_intro_cart;
    private Button btn_intro_buy;
    private TextView tv_intro_reduce;
    private TextView tv_intro_add;
    private EditText edt_intro_cnt;
    private Bundle bundle;
    private Intent intent;
    private Product product;
    private int cnt;
    private String userName;
    private double totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        intent = getIntent();
        bundle = intent.getExtras();
        product = (Product) bundle.getSerializable("product");

        initViews();

        initEvents();
    }

    private void initEvents() {
        tv_intro_add.setOnClickListener(v->{
            cnt=Integer.parseInt(edt_intro_cnt.getText().toString());
            if(cnt==product.getNowCnt()){
                Toast.makeText(
                        IntroActivity.this,
                        "购买个数不能超过存货数",
                        Toast.LENGTH_LONG
                ).show();
            }else{
                cnt++;

                edt_intro_cnt.setText(String.valueOf(cnt));
            }
        });

        tv_intro_reduce.setOnClickListener(v -> {
            cnt=Integer.parseInt(edt_intro_cnt.getText().toString());
            if(cnt==0)
            {
                Toast.makeText(
                        IntroActivity.this,
                        "购买个数不能小于0",
                        Toast.LENGTH_LONG
                ).show();
            }
            else
            {
                cnt--;
                edt_intro_cnt.setText(String.valueOf(cnt));
            }
        });

        //加入购物车 更新数据表 获取购物车数据 跳转购物车界面
        btn_intro_cart.setOnClickListener(v->{
            CartDao.addCart(new Cart(UserInfo.getUserName(),product.getName(),product.getPrice(),cnt,product.getImg()));


        });

        //购买 更新总单 详情 库存 返回主界面
        btn_intro_buy.setOnClickListener(v->{
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    if(cnt>0){
                        //库存减少
                        ProductDao.reduceProduct(product,cnt);

                        //添加总订单
                        userName = UserInfo.getUserName();
                        totalPrice = product.getPrice()*cnt;
                        String buyTime = DateMethod.getDate();

                        TotalBuy totalBuy = new TotalBuy(userName, buyTime,totalPrice);
                        TotalBuyDao.addTotalBuy(totalBuy);

                        //添加详情单
                        Buy buy = new Buy(UserInfo.getUserName(),product.getName(),product.getPrice(),cnt,product.getImg(),buyTime);
                        BuyDao.addBuy(buy);
                    }
                }
            });

            thread.start();

            try {
                thread.join();

                intent = new Intent(
                        IntroActivity.this,
                        ShopActivity.class
                );

                startActivity(intent);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private void initViews() {
        iv_intro_img = findViewById(R.id.iv_intro_img);

        Glide.with(this)
                .asBitmap()
                .load(product.getImg())
                .placeholder(R.mipmap.loading)
                .error(R.mipmap.error)
                .fallback(R.mipmap.empty)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(iv_intro_img);

        tv_intor_name = findViewById(R.id.tv_intro_name);
        tv_intor_name.setText(product.getName());

        tv_intro_nowCnt = findViewById(R.id.tv_intro_nowCnt);
        tv_intro_nowCnt.setText(String.valueOf(product.getNowCnt()));

        tv_intro_price = findViewById(R.id.tv_intro_price);
        tv_intro_price.setText(String.valueOf(product.getPrice()));

        btn_intro_cart = findViewById(R.id.btn_intro_cart);
        btn_intro_buy = findViewById(R.id.btn_intro_buy);
        tv_intro_reduce = findViewById(R.id.tv_intro_reduce);
        tv_intro_add = findViewById(R.id.tv_intro_add);

        edt_intro_cnt = findViewById(R.id.edt_intro_cnt);
        edt_intro_cnt.setText("1");

        cnt=1;
    }
}