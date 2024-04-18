package com.software.Teach1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.animation.AnimatableView;

public class LoginMainActivity extends AppCompatActivity implements View.OnClickListener{




    private EditText edt_name;
    private EditText edt_pwd;
    private Button btn_login;
    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);

        LinearLayout layout = (LinearLayout) findViewById(R.id.back);
        layout.getBackground().setAlpha((int) 50);

        findViews();

        /*btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edt_name.getText().toString();
                String pwd = edt_pwd.getText().toString();

                Toast.makeText(LoginMainActivity.this,
                        name+','+pwd,
                        Toast.LENGTH_LONG).show();
            }
        });*/

        //lambda 写法
        /*btn_login.setOnClickListener(v->{
            String name = edt_name.getText().toString();
            String pwd = edt_pwd.getText().toString();

            Toast.makeText(LoginMainActivity.this,name+','+pwd,Toast.LENGTH_LONG).show();
        });*/

        /*btn_register.setOnClickListener(v -> {
            Toast.makeText(LoginMainActivity.this,
                    "欢迎使用注册",
                    Toast.LENGTH_LONG).show();
        });*/

        //使用自定义监听
        /*LoginListener loginListener = new LoginListener();
        btn_login.setOnClickListener(loginListener);
        btn_register.setOnClickListener(loginListener);*/

        //直接让activity实现监听
        btn_login.setOnClickListener(this);
        btn_register.setOnClickListener(this);

    }

    // Alt + enter 全部获取方法 CTRL + alt + f 单个提取

    private void findViews() {
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_register = (Button) findViewById(R.id.btn_register);
        edt_name = (EditText) findViewById(R.id.edt_name);
        edt_pwd = (EditText) findViewById(R.id.edt_pwd);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        //用户点击控件的id与资源控件对比

        if(id==R.id.btn_login){
            String name = edt_name.getText().toString();
            String pwd = edt_pwd.getText().toString();

            Toast.makeText(LoginMainActivity.this,
                    name+','+pwd+" 登录中",
                    Toast.LENGTH_LONG).show();
        } else if(id==R.id.btn_register){
            Toast.makeText(LoginMainActivity.this,
                    "欢迎使用注册",
                    Toast.LENGTH_LONG).show();

            System.out.println("我注册了一个用户");
            Log.i("LoginActivity","用户注册了");
            finish();
        }else if(id==R.id.newpage)
        {
            //finish();
            startActivity(new Intent(this,MainActivity.class));
        }
    }

    /*class LoginListener implements View.OnClickListener{//自定义监听
        @Override
        public void onClick(View v) {
            int id = v.getId();
            //用户点击控件的id与资源控件对比

            if(id==R.id.btn_login){
                String name = edt_name.getText().toString();
                String pwd = edt_pwd.getText().toString();

                Toast.makeText(LoginMainActivity.this,
                        name+','+pwd,
                        Toast.LENGTH_LONG).show();
            } else if(id==R.id.btn_register){
                Toast.makeText(LoginMainActivity.this,
                        "欢迎使用注册",
                        Toast.LENGTH_LONG).show();

            }
        }
    }*/

}