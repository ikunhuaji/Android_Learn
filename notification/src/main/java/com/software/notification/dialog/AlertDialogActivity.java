package com.software.notification.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.software.notification.R;
import com.software.notification.toast.ToastActivity;

import java.util.Calendar;

public class AlertDialogActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_exit;
    private Button btn_date;
    private TextView tv_date;
    private Button btn_time;
    private TextView tv_time;
    private Button btn_custom;
    private Button btn_jump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

        initViews();
        initEvents();
    }

    private void initEvents() {
        btn_exit.setOnClickListener(this);
        btn_date.setOnClickListener(this);
        btn_time.setOnClickListener(this);
        btn_custom.setOnClickListener(this);
        btn_jump.setOnClickListener(this);
    }


    private void initViews(){
        btn_exit = findViewById(R.id.btn_exit);

        btn_date = findViewById(R.id.btn_date);
        tv_date = findViewById(R.id.tv_date);

        btn_time = findViewById(R.id.btn_time);
        tv_time = findViewById(R.id.tv_time);

        //自定义对话框
        btn_custom = findViewById(R.id.btn_custon);

        btn_jump = findViewById(R.id.btn_jump);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id==R.id.btn_exit){
//            创建选择对话框
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setIcon(R.mipmap.msg);
            builder.setMessage("您确定要退出吗");
            builder.setTitle("温馨提示");
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //退出程序
                    AlertDialogActivity.this.finish();
                }
            });
//            设置点击空白区域不能退出
            builder.setCancelable(false);
//            设置取消按钮
            builder.setNegativeButton("取消",null);
//            绑定展示对话框
            AlertDialog dialog = builder.create();
            dialog.show();

        }
        else if(id==R.id.btn_date){//日期选择对话框
            Calendar calendar = Calendar.getInstance();
            DatePickerDialog dialog = new DatePickerDialog(
                    this,
                    new DatePickerDialog.OnDateSetListener(){

                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            String desc = String.format("您选择的日期是%d年%d月%d日",year,month,dayOfMonth);
                            tv_date.setText(desc);
                        }
                    },
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DATE)
            );
            dialog.show();
        }
        else if(id==R.id.btn_time){
            Calendar calendar = Calendar.getInstance();
            TimePickerDialog dialog = new TimePickerDialog(
                this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String desc = String.format("您选择的时间是%d时%d分",hourOfDay,minute);
                        tv_time.setText(desc);
                    }
                },
                calendar.get(Calendar.HOUR),
                calendar.get(Calendar.MINUTE),
                true
            );
            dialog.show();
        }
        else if(id==R.id.btn_custon){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setIcon(R.mipmap.msg);
            builder.setTitle("留作业");
            //获取xml
            View view = getLayoutInflater().inflate(R.layout.dialog_cumtom,null);
            //给自定义对话框视图绑定事件
            Button btn_ok = view.findViewById(R.id.btn_ok);
            btn_ok.setOnClickListener(w->{
                TextView tv_homework = view.findViewById(R.id.tv_homework);
                tv_homework.setText("过周末");
            });
            //绑定xml
            builder.setView(view);

            AlertDialog dialog = builder.create();
            dialog.show();
        }
        else if(id==R.id.btn_jump){
            startActivity(new Intent(this, ToastActivity.class));
        }
    }
}