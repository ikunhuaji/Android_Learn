package com.software.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn_delete_db;
    private Button btn_create_db;
    private TextView tv_desc;
    private String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initEvent();

        //主文件夹下创建 user.db 地址
        path = getFilesDir()+"/user.db";
    }

    private void initEvent() {
        //创建数据库
        btn_create_db.setOnClickListener(v->{
            SQLiteDatabase db = openOrCreateDatabase(path, Context.MODE_PRIVATE,null);

            String desc = String.format("数据库%s创建%s",db.getPath(),(db!=null)?"成功":"失败");

            tv_desc.setText(desc);
        });

        //删除数据库
        btn_delete_db.setOnClickListener(v->{
            boolean result = deleteDatabase(path);

            String desc = String.format("数据库%s删除%s",path,result?"成功":"失败");

            tv_desc.setText(desc);
        });
    }

    private void initView() {
        btn_create_db = findViewById(R.id.btn_create_db);
        btn_delete_db = findViewById(R.id.btn_delete_db);
        tv_desc = findViewById(R.id.tv_desc);
    }
}