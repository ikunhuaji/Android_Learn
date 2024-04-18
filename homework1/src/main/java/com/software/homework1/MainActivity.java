package com.software.homework1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText username;
    private EditText pwd;
    private Button login;

    private void findViews() {
        username = (EditText) findViewById(R.id.username);
        pwd = (EditText) findViewById(R.id.pwd);
        login = (Button) findViewById(R.id.login);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();

        if(id==R.id.login){
            String name = username.getText().toString();
            String password = pwd.getText().toString();

            if(name.length()>0&&password.length()>0) {
                if(password.length()>=6) {
                    Toast.makeText(
                            MainActivity.this,
                            "恭喜，登录成功",
                            Toast.LENGTH_LONG
                    ).show();
                    System.out.println("登录成功");
                }
                else {
                    Toast.makeText(
                            MainActivity.this,
                            "密码长度不能小于6",
                            Toast.LENGTH_LONG
                    ).show();
                    System.out.println("密码长度小于6");
                }
            }
            else {
                Toast.makeText(
                        MainActivity.this,
                        "用户名和密码不能为空",
                        Toast.LENGTH_LONG
                ).show();
                System.out.println("用户名或密码为空");
            }
        }
    }
}