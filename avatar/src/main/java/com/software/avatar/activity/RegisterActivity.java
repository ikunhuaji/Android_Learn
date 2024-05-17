package com.software.avatar.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.software.avatar.R;

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

    }

    private void initViews() {
        edt_register_phone = findViewById(R.id.edt_register_phone);
        edt_register_password = findViewById(R.id.edt_register_password);
        btn_register = findViewById(R.id.btn_register);
    }
}