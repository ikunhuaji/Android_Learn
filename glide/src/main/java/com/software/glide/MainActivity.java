package com.software.glide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView iv_avatar = findViewById(R.id.iv_avatar);

        //Glide 获取网络图片
        Glide.with(this)
                .load("https://t11.baidu.com/it/u=4241520012,198480940&fm=30&app=106&f=JPEG?w=640&h=615&s=36381A8AC8D707E3560DBD6C03005040")
                .transform(new CircleCrop())
                .into(iv_avatar);

    }
}