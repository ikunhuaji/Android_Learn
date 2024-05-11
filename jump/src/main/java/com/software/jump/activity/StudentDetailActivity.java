package com.software.jump.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.software.jump.R;
import com.software.jump.entity.Student;

public class StudentDetailActivity extends AppCompatActivity {

    private EditText edt_student_name;
    private Button btn_back;
    private Button btn_other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);

        initView();

        String name = "";

        Intent intent = getIntent();

        //获取Intent传参extra
//        String name = intent.getStringExtra("name");

        //Bundle
//        Bundle bundle = intent.getExtras();
//        name = bundle.getString("name");

        //传对象
        Student student = (Student) intent.getSerializableExtra("student");

        //绑定参数
        //edt_student_name.setText(name);
        edt_student_name.setText(student.getName());

        btn_back.setOnClickListener(v->{
            //返回数据
            Intent back = new Intent();
            back.putExtra("newStudentName",edt_student_name.getText());
            setResult(201,back);//状态码，数据
            finish();
        });

        //打开另一个APP
        btn_other.setOnClickListener(v->{
            Intent other = new Intent();
            ComponentName componentName = new ComponentName(
                    "com.software.thread",
                    "com.software.thread.MainActivity"
            );
            other.setComponent(componentName);
            startActivity(other);
        });
    }

    private void initView() {
        edt_student_name = findViewById(R.id.edt_student_name);
        btn_back = findViewById(R.id.btn_back);
        btn_other = findViewById(R.id.btn_other);
    }


}