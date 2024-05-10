package com.software.tread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private TextView tv_baidu;
    private Button btn_baidu;
    private Button btn_img;
    private ImageView iv_img;

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        handler=new Handler(Looper.getMainLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {
                //图像与控件绑定
                if(msg.what==1){
                    Bitmap bitmap = (Bitmap) msg.obj;
                    iv_img.setImageBitmap(bitmap);
                }
            }
        };

        //绑定访问百度
        btn_baidu.setOnClickListener(v->{
            new Thread(){
                @Override
                public void run() {
                    visitBaidu();
                }
            }.start();
        });

        //绑定下载头像
        btn_img.setOnClickListener(v->{
            new Thread(){
                @Override
                public void run() {
                    downloadImg("https://i1.hdslb.com/bfs/archive/6acafe45f212fa4b54f1fb849fa4cea3453a3b9c.jpg");
                }
            }.start();
        });
    }

    private void downloadImg(String imgUrl) {
        URL url = null;
        InputStream is=null;

        try {
            url = new URL(imgUrl);
            is=url.openStream();

            //BitmapFactory 创建 BitMap 图像
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            //设置图像
            //获取message 使用handler的，连接池概念
            Message message = handler.obtainMessage();
            message.what=1;
            message.obj=bitmap;
            //消息队列发送
            handler.sendMessage(message);
            //iv_img.setImageBitmap(bitmap);

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //关闭资源
            if(is!=null){
                try {
                    is.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    //子线程运行
    private void visitBaidu() {
        URL url = null;
        InputStream is=null;
        try {
            //创建URL
            url = new URL("https://www.baidu.com");

            //获得流
            is=url.openStream();

            //读取流
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String read = null;
            StringBuffer sb = new StringBuffer();
            while ((read = br.readLine())!=null){
                sb.append(read);
            }

            //放入TextView
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tv_baidu.setText(sb.toString());
                }
            });

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //关闭资源
            if(is!=null){
                try {
                    is.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    private void initViews() {
        btn_baidu = findViewById(R.id.btn_baidu);
        tv_baidu = findViewById(R.id.tv_baidu);
        btn_img = findViewById(R.id.btn_img);
        iv_img = findViewById(R.id.iv_img);

    }
}