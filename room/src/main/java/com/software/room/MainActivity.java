package com.software.room;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.software.room.dao.UserInfoDao;
import com.software.room.database.UserInfoDatabase;
import com.software.room.entity.UserInfo;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText edt_name;
    private EditText edt_age;
    private EditText edt_height;
    private EditText edt_weight;
    private Button btn_insert;
    private EditText edt_find_id;
    private Button btn_find_id;
    private Button btn_query;
    private EditText edt_delete_id;
    private Button btn_delete_id;
    private Button btn_update;
    private UserInfoDao userInfoDao;

    @Override
    protected void onStart() {
        super.onStart();
        userInfoDao = UserInfoDatabase
                .getInstance(this)
                .getUserInfoDao();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        initEvents();
    }

    private void initEvents() {
        btn_insert.setOnClickListener(v->{
            UserInfo userInfo = new UserInfo();
            userInfo.setName(edt_name.getText().toString());
            userInfo.setAge(Integer.valueOf(edt_age.getText().toString()));
            userInfo.setHeight(Integer.valueOf(edt_height.getText().toString()));
            userInfo.setWeight(Float.valueOf(edt_weight.getText().toString()));
            userInfoDao.insert(userInfo);

            Toast.makeText(this, "新增成功", Toast.LENGTH_SHORT).show();
        });

        btn_delete_id.setOnClickListener(v -> {
            if(edt_delete_id.getText().toString().equals("")){
                Toast.makeText(this, "请先输入删除信息的ID", Toast.LENGTH_SHORT).show();
            }else {
                Integer id = Integer.valueOf(edt_delete_id.getText().toString());
                UserInfo userInfo = userInfoDao.queryByID(id);

                if(userInfo == null){
                    Toast.makeText(this, "删除的数据不存在", Toast.LENGTH_SHORT).show();
                }else {
                    userInfo = new UserInfo();
                    userInfo.setId(Integer.valueOf(edt_delete_id.getText().toString()));

                    userInfoDao.delete(userInfo);
                    Toast.makeText(this, "删除成功", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_update.setOnClickListener(v->{
            if(edt_find_id.getText().toString().equals("")){
                Toast.makeText(this, "请先输入修改信息的ID", Toast.LENGTH_SHORT).show();
            }else {
                Integer id = Integer.valueOf(edt_find_id.getText().toString());

                UserInfo userInfo = userInfoDao.queryByID(id);
                if(userInfo == null){
                    Toast.makeText(this, "修改的数据不存在", Toast.LENGTH_SHORT).show();
                }else{
                    userInfo.setId(Integer.valueOf(edt_find_id.getText().toString()));
                    userInfo.setName(edt_name.getText().toString());
                    userInfo.setAge(Integer.valueOf(edt_age.getText().toString()));
                    userInfo.setHeight(Integer.valueOf(edt_height.getText().toString()));
                    userInfo.setWeight(Float.valueOf(edt_weight.getText().toString()));

                    userInfoDao.update(userInfo);
                    Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_query.setOnClickListener(v -> {
            List<UserInfo> userInfos = userInfoDao.quaryAll();

            for (UserInfo userInfo:userInfos){
                Log.i("user-info",userInfo.toString());
            }
        });

        btn_find_id.setOnClickListener(v -> {
            if(edt_find_id.getText().toString().equals("")){
                Toast.makeText(this, "请先输入查询信息的ID", Toast.LENGTH_SHORT).show();
            }else {
                Integer id = Integer.valueOf(edt_find_id.getText().toString());

                UserInfo userInfo = userInfoDao.queryByID(id);

                if(userInfo == null){
                    Toast.makeText(this, "查询的数据不存在", Toast.LENGTH_SHORT).show();
                }else {
                    edt_name.setText(userInfo.getName());
                    edt_age.setText(String.valueOf(userInfo.getAge()));
                    edt_height.setText(String.valueOf(userInfo.getHeight()));
                    edt_weight.setText(String.valueOf(userInfo.getWeight()));

                    Toast.makeText(this, "回显成功", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initViews() {
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