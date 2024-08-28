package com.software.sqlite.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.software.sqlite.R;
import com.software.sqlite.database.UserDBHelper;
import com.software.sqlite.entity.UserInfo;

public class UserInfoActivity extends AppCompatActivity {

    private EditText edt_name;
    private EditText edt_age;
    private EditText edt_height;
    private EditText edt_weight;
    private Button btn_insert;
    private UserDBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        initView();

        initEvent();
    }

    @Override
    protected void onStart() {//应用启动
        super.onStart();
        helper = UserDBHelper.getInstance(this);
        helper.openReadLink();
        helper.openWriteLink();
    }

    @Override
    protected void onStop() {//应用关闭
        super.onStop();
        helper.closeLink();
    }

    private void initEvent() {
        btn_insert.setOnClickListener(v -> {
            //创建数据库
            //打开连接
            //保存数据
            UserInfo userInfo = new UserInfo();
            userInfo.setName(edt_name.getText().toString());
            userInfo.setAge(Integer.valueOf(edt_age.getText().toString()));
            userInfo.setHeight(Integer.valueOf(edt_height.getText().toString()));
            userInfo.setWeight(Float.valueOf(edt_weight.getText().toString()));
            long row = helper.insert(userInfo);
            if(row>0)
            {
                Toast.makeText(this,"新增成功",Toast.LENGTH_SHORT).show();
            }
            //关闭连接
        });
    }

    private void initView() {
        edt_name = findViewById(R.id.edt_name);
        edt_age = findViewById(R.id.edt_age);
        edt_height = findViewById(R.id.edt_height);
        edt_weight = findViewById(R.id.edt_weight);
        btn_insert = findViewById(R.id.btn_insert);
    }
}