package com.software.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    private static String TAG = "ikunhuaji";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btn_back = findViewById(R.id.btn_back);

        Log.i(TAG,"onCreate");

        btn_back.setOnClickListener(v->{
            Intent intent = new Intent(
                    SecondActivity.this,
                    MainActivity.class
            );

            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//用于设置启动模式
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