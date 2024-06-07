package com.software.resources;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private ImageView iv_state;
    private Button btn_raw;
    private ImageView iv_raw;
    private Button btn_assets;
    private ImageView iv_assets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        initEvents();
    }

    private void initEvents() {
        iv_state.setOnClickListener(v->{

        });

        btn_raw.setOnClickListener(v->{
            //获取 resources 管理器
            Resources rs = getResources();

            //流形式获取图片资源，简化流式操作
            InputStream is = rs.openRawResource(R.raw.genshin);

            //显示在控件上
            Bitmap bitmap = BitmapFactory.decodeStream(is);

            iv_raw.setImageBitmap(bitmap);
        });

        btn_assets.setOnClickListener(v->{
            //获取AssetManger管理器
            AssetManager assetManager = getAssets();

            //流形式获取图片资源，简化流式操作
            try {
                InputStream is = assetManager.open("genshin.png");

                //显示在控件上
                Bitmap bitmap = BitmapFactory.decodeStream(is);
                iv_assets.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void initViews() {
        iv_state = findViewById(R.id.iv_state);
        btn_raw = findViewById(R.id.btn_raw);
        iv_raw = findViewById(R.id.iv_raw);
        btn_assets = findViewById(R.id.btn_assets);
        iv_assets = findViewById(R.id.iv_assets);
    }
}