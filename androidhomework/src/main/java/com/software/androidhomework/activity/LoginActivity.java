package com.software.androidhomework.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.software.androidhomework.R;
import com.software.androidhomework.entity.UserInfo;
import com.software.androidhomework.entity.Result;
import com.software.androidhomework.entity.User;
import com.software.androidhomework.utils.HostUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class LoginActivity extends AppCompatActivity {

    private EditText edt_login_userName;
    private EditText edt_login_pwd;
    private Button btn_login;
    private Button btn_back_to_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

        initEvents();
    }

    private void initEvents() {
        btn_back_to_register.setOnClickListener(v->{
            gotoRegister();
        });

        btn_login.setOnClickListener(v->{
            String userName = edt_login_userName.getText().toString();
            String pwd = edt_login_pwd.getText().toString();
            new Thread(){
                @Override
                public void run() {
                    login(userName,pwd);
                }
            }.start();
        });
    }

    private void login(String userName, String pwd) {
        InputStream is = null;
        try {
            URL url = new URL(HostUtil.HOST+"/login?userName="+userName+"&pwd="+pwd);
            is=url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String json = br.readLine();
            Gson gson = new Gson();

            Result result = gson.fromJson(json,new TypeToken<Result<User>>(){}.getType());

            if(result.getCode()!=200) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(
                                LoginActivity.this,
                                result.getMsg(),
                                Toast.LENGTH_SHORT
                        ).show();
                    }
                });
            }else{
                User user = (User) result.getData();
                UserInfo.update(user);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(
                                LoginActivity.this,
                                result.getMsg(),
                                Toast.LENGTH_SHORT
                        ).show();
                        gotoShop();
                    }
                });
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void gotoShop() {
        Intent intent = new Intent(
                LoginActivity.this,
                ShopActivity.class
        );
        startActivity(intent);
    }


    private void gotoRegister() {
        Intent intent = new Intent(
                LoginActivity.this,
                RegisterActivity.class
        );
        startActivity(intent);
    }

    private void initViews() {
        edt_login_userName = findViewById(R.id.edt_login_userName);
        edt_login_pwd = findViewById(R.id.edt_login_pwd);
        btn_login = findViewById(R.id.btn_login);
        btn_back_to_register = findViewById(R.id.btn_back_to_register);
    }
}