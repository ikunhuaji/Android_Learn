package com.software.jump.activity;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.software.jump.R;
import com.software.jump.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentListActivity extends AppCompatActivity {

    private ListView lv_student_list;
    private List<String> studentList;

    private ActivityResultLauncher launcher;
    private ArrayAdapter<String> adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        initView();

        initData();

        //初始化Launcher
        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode()==201){
                            Intent backIntent = result.getData();
                            String newName = backIntent.getStringExtra("newStudentName");

                            studentList.add(newName);
                            adapter.notifyDataSetChanged();//通知adapter数据更新
                        }
                    }
                }//回调
        );

        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                studentList
        );

        lv_student_list.setAdapter(adapter);


        lv_student_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //获取数据
                String studentName = studentList.get(position);

                //intent
                Intent intent = new Intent(
                        StudentListActivity.this,
                        StudentDetailActivity.class
                );

                //第一种传参方式，Intent的Extra
                //intent.putExtra("name",studentName);

                //第二种传参 bundle
//                Bundle bundle = new Bundle();
//                bundle.putString("name",studentName);
//                intent.putExtras(bundle);
                //第三种 传对象 通过 Serializable 序列化

                Student student = new Student(studentName);
                intent.putExtra("student",student);

                //跳转
                //startActivity(intent);

                //可获取返回值的跳转
                launcher.launch(intent);
            }
        });




    }

    private void initData() {
        studentList = new ArrayList<>();

        studentList.add("张三");
        studentList.add("李四");
        studentList.add("王五");
    }

    private void initView() {
        lv_student_list = findViewById(R.id.lv_student_list);
    }
}