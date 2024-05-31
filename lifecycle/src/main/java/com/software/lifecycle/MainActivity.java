package com.software.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "ikunhuaji";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG,"onCreate");

        Button btn_next = findViewById(R.id.btn_next);

        btn_next.setOnClickListener(v->{
            Intent intent = new Intent(
                    MainActivity.this,
                    SecondActivity.class
            );

            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//用于设置启动模式
            startActivity(intent);
        });

        //打开电话
        Button btn_phone = findViewById(R.id.btn_phone);
        btn_phone.setOnClickListener(v->{
            Intent intent = new Intent();
            //隐式调用
            intent.setAction(Intent.ACTION_DIAL);
            //指定电话
            //data 是一个 URI
            Uri uri = Uri.parse("tel:10086");
            intent.setData(uri);
            startActivity(intent);
        });

        Button btn_send = findViewById(R.id.btn_send);
        btn_send.setOnClickListener(v->{
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SENDTO);
            Uri uri = Uri.parse("smsto:10086");

            intent.setData(uri);
            startActivity(intent);
        });

        Button btn_local = findViewById(R.id.btn_local);
        btn_local.setOnClickListener(v->{
            Intent intent = new Intent();
            intent.setAction("software");
            intent.addCategory(Intent.CATEGORY_DEFAULT);

            startActivity(intent);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"onPause");
    }
}