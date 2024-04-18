package com.software.Teach1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layout = (LinearLayout) findViewById(R.id.kunkun);
        layout.getBackground().setAlpha((int) 50);

        //获取view用户编辑框中的文本
        EditText edt_username = findViewById(R.id.edt_username);
        //edt_username.setText("1145141919810");
        EditText title = findViewById(R.id.title);
        Button button1 = (Button) findViewById(R.id.but1);
        Button button2 = (Button) findViewById(R.id.but2);

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                title.setText("登录……");
                Toast.makeText(MainActivity.this,
                        "跳转登录界面",
                        Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this, LoginMainActivity.class));
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                title.setText("注册……");
            }
        });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id==R.id.newpage)
        {
            startActivity(new Intent(MainActivity.this, LoginMainActivity.class));
        }
    }
}