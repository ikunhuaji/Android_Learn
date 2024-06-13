package com.software.androidhomework.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.software.androidhomework.R;

public class MainActivity extends AppCompatActivity {

    private Button btn_to_register;
    private Button btn_to_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        initEvents();
    }

    private void initEvents() {
        btn_to_login.setOnClickListener(v->{
            Intent intent = new Intent(
                    MainActivity.this,
                    LoginActivity.class
            );

            startActivity(intent);
        });

        btn_to_register.setOnClickListener(v->{
            Intent intent = new Intent(
                    MainActivity.this,
                    RegisterActivity.class
            );

            startActivity(intent);
        });
    }

    private void initViews() {
        btn_to_login = findViewById(R.id.btn_to_login);
        btn_to_register = findViewById(R.id.btn_to_register);

    }
}