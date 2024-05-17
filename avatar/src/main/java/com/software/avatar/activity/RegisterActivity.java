package com.software.avatar.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.software.avatar.R;
import com.software.avatar.entity.UserInfo;
import com.software.avatar.utils.HostUtil;
import com.software.avatar.utils.Result;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class RegisterActivity extends AppCompatActivity {

    private Button btn_register;
    private EditText edt_register_password;
    private EditText edt_register_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initViews();

        initEvents();
    }

    private void initEvents() {
        //注册事件
        btn_register.setOnClickListener(v->{
            //获取手机号和密码
            String phone = edt_register_phone.getText().toString();
            String password = edt_register_password.getText().toString();

            //发送请求到Servlet
            new Thread(){
                @Override
                public void run() {
                    register(phone,password);
                }
            }.start();

            //接收结果

        });
    }

    private void register(String phone, String password) {
        InputStream is = null;
        try{
            URL url = new URL(HostUtil.HOST+"/register?phone="+phone+"&password="+password);
            is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String json = br.readLine();
            Gson gson = new Gson();
            Result result = gson.fromJson(json,new TypeToken<Result<UserInfo>>(){}.getType());
            if(result.getCode()!=200){
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(
                                RegisterActivity.this,
                                result.getMsg(),
                                Toast.LENGTH_SHORT
                        ).show();
                    }
                });
            }else{
                //go to login
//                Toast.makeText(
//                        RegisterActivity.this,
//                        "OK",
//                        Toast.LENGTH_SHORT
//                ).show();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(
                                RegisterActivity.this,
                                result.getMsg(),
                                Toast.LENGTH_SHORT
                        ).show();
                        gotoLogin();
                    }
                });

            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void gotoLogin() {
        Intent intent = new Intent(
                RegisterActivity.this,
                LoginActivity.class
        );
        startActivity(intent);
    }

    private void initViews() {
        edt_register_phone = findViewById(R.id.edt_register_phone);
        edt_register_password = findViewById(R.id.edt_register_password);
        btn_register = findViewById(R.id.btn_register);
    }
}