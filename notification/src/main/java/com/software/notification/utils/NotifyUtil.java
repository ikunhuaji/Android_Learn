package com.software.notification.utils;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;

import androidx.core.app.NotificationCompat;

import com.software.notification.R;
import com.software.notification.notifications.NotificationActivity;

public class NotifyUtil {
    private static final String CHANNEL_ID = "wechat";
    private static final String CHANNEL_NAME = "微信";

    private NotificationManager manager;

    private Context context;

    public NotifyUtil(Context context,Integer importance){
        this.context=context;
        manager=(NotificationManager) context.getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

        //渠道
        createNotificationChannel(importance);
    }

    public void sendNotify(String title,String message,Integer smallIcon,Integer largeIcon) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,CHANNEL_ID);
        builder.setContentText(message);
        builder.setContentTitle(title);
        builder.setSmallIcon(smallIcon);
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(),largeIcon));
        Notification notification = builder.build();
        manager.notify(R.string.app_name,notification);
    }

    private void createNotificationChannel(Integer importance) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    CHANNEL_NAME,
                    importance
            );


            //设置声音
            channel.setSound(null,null);
            //红点
            channel.setShowBadge(true);
            //跑马灯
            channel.enableLights(true);
            //震动
            channel.enableVibration(true);
            //锁屏显示
            channel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);

            manager.createNotificationChannel(channel);
        }



    }
}
