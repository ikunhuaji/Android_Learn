package com.software.shared;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private EditText edt_username;
    private EditText edt_password;
    private CheckBox cb_remember;
    private CheckBox cb_auto_login;
    private Button btn_login;
    private SharedPreferences preferences;
    private Button btn_save;
    private Button btn_sd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initShared();

        initEvent();

        initData();
    }

    private void initData() {
        //第二个参数为默认值 如果shared里没有remember返回false
        Boolean remember = preferences.getBoolean("remember",false);
        Boolean autoLogin = preferences.getBoolean("autoLogin", false);

        //显示
        cb_remember.setChecked(remember);
        cb_auto_login.setChecked(autoLogin);

        if(remember)
        {
            //回显数据
            edt_username.setText(preferences.getString("username",""));
            edt_password.setText(preferences.getString("password",""));
        }

        if(autoLogin){
            //模拟登录逻辑
            Toast.makeText(this,"自动登录成功",Toast.LENGTH_LONG).show();
        }
    }

    private void initEvent() {
        btn_login.setOnClickListener(v->{
            //点击登录
            SharedPreferences.Editor edit = preferences.edit();

            //存储是否选中
            edit.putBoolean("remember",cb_remember.isChecked());
            //自动登录是否选中
            edit.putBoolean("autoLogin",cb_auto_login.isChecked());

            if(cb_remember.isChecked()){//记住
                //存入账号密码
                edit.putString("username",edt_username.getText().toString());
                edit.putString("password",edt_password.getText().toString());
            }

            //提交保存
            edit.commit();// 同步，需要得到返回结果使用，执行出错应用出错

//        edit.apply();// 异步，不需要返回结果，起另一个线程，执行出错不影响应用程序

            Toast.makeText(this,"保存成功",Toast.LENGTH_LONG).show();
        });

        //读写应用程序内部文件
        btn_save.setOnClickListener(v->{
            try {
                FileOutputStream fos = openFileOutput("happy.text", Context.MODE_PRIVATE);
                fos.write("开学了(悲 😭".getBytes());
                fos.flush();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Toast.makeText(this,"写入内部文件成功",Toast.LENGTH_LONG).show();
        });

        btn_sd.setOnClickListener(v->{
            //判断是否存在sd卡
            String storageState = Environment.getExternalStorageState();

            //存在sd卡
            if(storageState.equals(Environment.MEDIA_MOUNTED)){
                //获取sd卡存文件的目录

            }
            else{

            }
        });
    }

    private void initShared() {
        //获取 SharedPreferences
        preferences = getSharedPreferences("config", Context.MODE_PRIVATE);
    }

    private void initView() {
        edt_username = findViewById(R.id.edt_username);
        edt_password = findViewById(R.id.edt_password);
        cb_remember = findViewById(R.id.cb_remember);
        cb_auto_login = findViewById(R.id.cb_auto_login);
        btn_login = findViewById(R.id.btn_login);
        btn_save = findViewById(R.id.btn_save);
        btn_sd = findViewById(R.id.btn_sd);
    }
}