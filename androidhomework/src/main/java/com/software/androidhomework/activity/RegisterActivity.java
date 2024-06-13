package com.software.androidhomework.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.software.androidhomework.R;
import com.software.androidhomework.entity.User;
import com.software.androidhomework.utils.HostUtil;
import com.software.androidhomework.entity.Result;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class RegisterActivity extends AppCompatActivity {

    private EditText edt_register_userName;
    private EditText edt_register_pwd;
    private EditText edt_register_storeName;
    private EditText edt_register_email;
    private Button btn_register;
    private Button btn_back_to_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initViews();

        initEvents();
    }

    private void initEvents() {
        btn_back_to_login.setOnClickListener(v->{
            gotoLogin();
        });

        btn_register.setOnClickListener(v->{
            String userName = edt_register_userName.getText().toString();
            String pwd = edt_register_pwd.getText().toString();
            String email = edt_register_email.getText().toString();
            String storeName = edt_register_storeName.getText().toString();

            new Thread(){
                @Override
                public void run() {
                    register(userName,pwd,email,storeName);
                }
            }.start();
        });
    }

    private void register(String userName, String pwd, String email, String storeName) {
        InputStream is = null;
        try {
            Log.i("test1","ss");
            URL url = new URL(HostUtil.HOST+"/register?userName="+userName+"&pwd="+pwd+"&email="+email+"&storeName="+storeName);
            is=url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String json = br.readLine();
            Gson gson = new Gson();

             Result result = gson.fromJson(json,new TypeToken<Result<User>>(){}.getType());

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
        edt_register_userName = findViewById(R.id.edt_register_userName);
        edt_register_pwd = findViewById(R.id.edt_register_pwd);
        edt_register_email = findViewById(R.id.edt_register_email);
        edt_register_storeName = findViewById(R.id.edt_register_storeName);
        btn_register = findViewById(R.id.btn_register);
        btn_back_to_login = findViewById(R.id.btn_back_to_login);
    }
}