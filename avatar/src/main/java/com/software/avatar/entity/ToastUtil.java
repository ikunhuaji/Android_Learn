package com.software.avatar.entity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

public class ToastUtil {
    public static void show(Context context,String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void show(Context context,String message,Integer layout){//自定义提示框
        View view = LayoutInflater.from(context).inflate(layout, null);
        Toast toast = new Toast(context);
        toast.setView(view);
//        toast.setDuration(); //显示时长
        toast.show();
    }
}
