package com.software.notification.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.software.notification.R;
import com.software.notification.notifications.NotificationActivity;
import com.software.notification.utils.ToastUtil;

public class ToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        Button btn_toast = findViewById(R.id.btn_toast);
        btn_toast.setOnClickListener(v->{
//            Toast toast = Toast.makeText(
//                    this,
//                    "提示框",
//                    Toast.LENGTH_SHORT
//            );
//            toast.show();
//            toast.setGravity();

            //自建提示框显示
//            ToastUtil.show(this,"提示框");
            //使用自定义提示框 ， 但不能使用事件
            ToastUtil.show(this,"提示框",R.layout.dialog_cumtom);


        });

        Button btn_jump1 = findViewById(R.id.btn_jump1);
        btn_jump1.setOnClickListener(w->{
            startActivity(new Intent(this, NotificationActivity.class));
        });


    }
}