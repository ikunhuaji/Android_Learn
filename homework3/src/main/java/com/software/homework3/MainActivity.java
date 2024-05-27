package com.software.homework3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_count;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        handler = new Handler(Looper.getMainLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {
                if(msg.what==1){
                    int nowCount=(int)msg.obj;
                    tv_count.setText(nowCount+"%");
                }
            }
        };

        runThread();
    }

    private void runThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int nowCount=0;
                while(nowCount<100) {
                    nowCount++;

                    if(nowCount%10==0) {
                        Message message = handler.obtainMessage();
                        message.what=1;
                        message.obj=nowCount;

                        handler.sendMessage(message);
                    }

                    try {
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private void initViews() {
        tv_count = findViewById(R.id.tv_count);
    }
}