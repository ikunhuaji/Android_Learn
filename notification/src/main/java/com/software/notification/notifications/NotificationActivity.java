package com.software.notification.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.software.notification.R;
import com.software.notification.utils.NotifyUtil;

public class NotificationActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_send;
    private EditText edt_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        initViews();
        initEvents();
    }

    private void initEvents() {
        btn_send.setOnClickListener(this);
    }

    private void initViews() {
        btn_send = findViewById(R.id.btn_send);
        edt_message = findViewById(R.id.edt_message);
    }

    @Override
    public void onClick(View v) {
        //发送通知
        //获取通知管理器
//        NotificationManager manager =
//                (NotificationManager) getApplicationContext()
//                        .getSystemService(Context.NOTIFICATION_SERVICE);
//
//        //通知渠道
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//            NotificationChannel channel = new NotificationChannel(
//                    "wechat",
//                    "微信",
//                    NotificationManager.IMPORTANCE_DEFAULT
//            );
//            manager.createNotificationChannel(channel);
//        }
//        //获取Builder
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(
//                this,
//                "wechat"
//        );
//        builder.setSmallIcon(R.mipmap.msg);
//        builder.setContentTitle("微信");
//        builder.setContentText(edt_message.getText());
//        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.msg));
//
////        构建通知
//        Notification notification = builder.build();
////        发送通知
//        manager.notify(R.string.app_name,notification);

        NotifyUtil util = new NotifyUtil(this,NotificationManager.IMPORTANCE_DEFAULT);

        util.sendNotify(
                "微信",
                edt_message.getText().toString(),
                R.mipmap.msg,
                R.mipmap.msg
        );
    }

}