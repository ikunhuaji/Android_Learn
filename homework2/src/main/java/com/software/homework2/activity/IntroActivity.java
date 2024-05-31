package com.software.homework2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.software.homework2.Db.CartDb;
import com.software.homework2.R;
import com.software.homework2.entity.Product;

public class IntroActivity extends AppCompatActivity {

    private ImageView iv_intro_image;
    private TextView tv_intor_name;
    private TextView tv_intro_intro;
    private TextView tv_intro_price;
    private Button btn_intro_back;
    private Button btn_intro_buy;
    private TextView tv_intro_reduce;
    private TextView tv_intro_add;
    private EditText edt_intro_cnt;
    private Bundle bundle;
    private Intent intent;
    private Product product;
    private int cnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        intent = getIntent();
        bundle = intent.getExtras();
        product = (Product) bundle.getSerializable("product");
        initViews();

        btn_intro_back.setOnClickListener(v->{
            intent = new Intent(
                    IntroActivity.this,
                    MainActivity.class
            );

            startActivity(intent);
        });

        btn_intro_buy.setOnClickListener(v->{
            cnt=Integer.parseInt(edt_intro_cnt.getText().toString());
            if(cnt>0)CartDb.add(product,cnt);

            intent = new Intent(
                    IntroActivity.this,
                    CartActivity.class
            );

            startActivity(intent);
        });

        tv_intro_add.setOnClickListener(v -> {
            cnt=Integer.parseInt(edt_intro_cnt.getText().toString());
            cnt++;

            edt_intro_cnt.setText(String.valueOf(cnt));
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
    }

    private void initViews() {
        iv_intro_image = findViewById(R.id.iv_intro_image);
        iv_intro_image.setImageResource(product.getImage());

        tv_intor_name = findViewById(R.id.tv_intro_name);
        tv_intor_name.setText(product.getName());

        tv_intro_intro = findViewById(R.id.tv_intro_intro);
        tv_intro_intro.setText(product.getIntro());

        tv_intro_price = findViewById(R.id.tv_intro_price);
        tv_intro_price.setText(String.valueOf(product.getPrice()));

        btn_intro_back = findViewById(R.id.btn_intro_back);
        btn_intro_buy = findViewById(R.id.btn_intro_buy);
        tv_intro_reduce = findViewById(R.id.tv_intro_reduce);
        tv_intro_add = findViewById(R.id.tv_intro_add);

        edt_intro_cnt = findViewById(R.id.edt_intro_cnt);
        edt_intro_cnt.setText("1");

        cnt=1;
    }
}