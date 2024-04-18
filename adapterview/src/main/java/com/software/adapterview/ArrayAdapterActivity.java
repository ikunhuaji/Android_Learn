package com.software.adapterview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ArrayAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter);

        List<String>courseList = new ArrayList<>();

        courseList.add("Android基础编程");
        courseList.add("智能设备方向基础课");
        courseList.add("数据库系统概论");
        courseList.add("操作系统");

        //适配器
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.item_course,
                courseList
        );
        //获取AdapterView
        ListView lv_course = findViewById(R.id.lv_course);
        //绑定
        lv_course.setAdapter(adapter);

        lv_course.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(
                        ArrayAdapterActivity.this,
                        courseList.get(position),
                        Toast.LENGTH_LONG
                ).show();
            }
        });
    }
}