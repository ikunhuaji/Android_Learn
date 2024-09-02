package com.software.sqlite.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.software.sqlite.R;
import com.software.sqlite.database.UserDBHelper;
import com.software.sqlite.entity.UserInfo;

import java.util.List;

public class UserInfoActivity extends AppCompatActivity {

    private EditText edt_name;
    private EditText edt_age;
    private EditText edt_height;
    private EditText edt_weight;
    private Button btn_insert;
    private UserDBHelper helper;
    private EditText edt_find_id;
    private Button btn_find_id;
    private Button btn_query;
    private EditText edt_delete_id;
    private Button btn_delete_id;
    private Button btn_update;
    private UserInfo userInfo;

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
                Toast.makeText(
                        this,
                        "新增成功",
                        Toast.LENGTH_SHORT
                ).show();
            }
            //关闭连接
        });

        btn_find_id.setOnClickListener(v->{
            String id = edt_find_id.getText().toString();

            UserInfo userInfo = helper.queryById(id);

            if (userInfo==null) {
                Toast.makeText(
                        this,
                        "所查询的数据不存在",
                        Toast.LENGTH_SHORT
                ).show();
            }
            else {
                edt_name.setText(userInfo.getName());
                edt_age.setText(String.valueOf(userInfo.getAge()));
                edt_height.setText(String.valueOf(userInfo.getHeight()));
                edt_weight.setText(String.valueOf(userInfo.getWeight()));

                Toast.makeText(
                        this,
                        "回显成功",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        //查询所有
        btn_query.setOnClickListener(v -> {
            List<UserInfo> userInfoList = helper.query();

            for(UserInfo userInfo:userInfoList){
                Log.i("user-info",userInfo.toString());
            }
        });

        btn_delete_id.setOnClickListener(v -> {
            String id = edt_delete_id.getText().toString();

            UserInfo userInfo = helper.queryById(id);

            if(userInfo==null){
                Toast.makeText(
                        this,
                        "所删除的数据不存在",
                        Toast.LENGTH_SHORT
                ).show();
            }
            else{
                long row = helper.delete(id);
                if(row>0){
                    Toast.makeText(
                            this,
                            "删除成功",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });

        btn_update.setOnClickListener(v -> {
            //查数据是否存在
            if(edt_name.getText().toString().equals("")){
                Toast.makeText(
                        this,
                        "请先查询数据",
                        Toast.LENGTH_SHORT
                ).show();
            }
            else {
                UserInfo userInfo = new UserInfo();
                userInfo.setId(Integer.valueOf(edt_find_id.getText().toString()));
                userInfo.setName(edt_name.getText().toString());
                userInfo.setAge(Integer.valueOf(edt_age.getText().toString()));
                userInfo.setHeight(Integer.valueOf(edt_height.getText().toString()));
                userInfo.setWeight(Float.valueOf(edt_weight.getText().toString()));

                long row = helper.update(userInfo);
                if(row>0){
                    Toast.makeText(
                            this,
                            "修改成功",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });
    }

    private void initView() {
        edt_name = findViewById(R.id.edt_name);
        edt_age = findViewById(R.id.edt_age);
        edt_height = findViewById(R.id.edt_height);
        edt_weight = findViewById(R.id.edt_weight);

        btn_insert = findViewById(R.id.btn_insert);

        edt_find_id = findViewById(R.id.edt_find_id);
        btn_find_id = findViewById(R.id.btn_find_id);

        btn_query = findViewById(R.id.btn_query);

        edt_delete_id = findViewById(R.id.edt_delete_id);
        btn_delete_id = findViewById(R.id.btn_delete_id);

        btn_update = findViewById(R.id.btn_update);
    }
}