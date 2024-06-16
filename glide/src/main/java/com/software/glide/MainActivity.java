package com.software.glide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;

public class MainActivity extends AppCompatActivity {

    private ImageView iv_avatar;
    private Button btn_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

//        https://t11.baidu.com/it/u=4241520012,198480940&fm=30&app=106&f=JPEG?w=640&h=615&s=36381A8AC8D707E3560DBD6C03005040
//        https://music-file.y.qq.com/comment/5a92b965e672d01113e3a529f49b80614d77a652_21c6e.gif
        btn_show.setOnClickListener(v->{
            //Glide 获取网络图片
//            Glide.with(this)
////                    .asGif()//动图加载
//                    .asBitmap()//静态图加载
//                    .load("https://img0.baidu.com/it/u=375285813,207104960&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500")
//                    .placeholder(R.mipmap.loading)//加载中的状态
//                    .error(R.mipmap.error)//加载失败
//                    .fallback(R.mipmap.empty)//加载为null
//                    .transform(new CircleCrop())//圆形框
//                    .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存策略
//                    .into(iv_avatar);

            GlideApp.with(this)
                    .load("https://t11.baidu.com/it/u=4241520012,198480940&fm=30&app=106&f=JPEG?w=640&h=615&s=36381A8AC8D707E3560DBD6C03005040")
                    .defaultImage()
                    .into(iv_avatar);
        });
    }

    private void initViews() {
        iv_avatar = findViewById(R.id.iv_avatar);
        btn_show = findViewById(R.id.btn_show);
    }
}