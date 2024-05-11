package com.software.jump;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.software.jump.activity.StudentListActivity;

public class MainActivity extends AppCompatActivity {

    private Button btn_open;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        btn_open.setOnClickListener(v->{
            Intent intent = new Intent(
                    MainActivity.this,
                    StudentListActivity.class
            );
            startActivity(intent);
        });
    }

    private void initView() {
        btn_open = findViewById(R.id.btn_open);
    }
}