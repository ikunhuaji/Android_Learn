package com.software.content_cilent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn_call_log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        initEvents();
    }

    private void initEvents() {
        // 可自学动态授权
        btn_call_log.setOnClickListener(v->{
            //cp 系统提供
            //cr
            ContentResolver resolver = getContentResolver();
            Cursor cursor =  resolver.query(CallLog.Calls.CONTENT_URI,null,null,null,null);//使用默认Uri,获取全部通话记录

            if(cursor.moveToFirst()){
                do{
                    //获取数据
                    int nameIndex = cursor.getColumnIndex(CallLog.Calls.CACHED_NAME);
                    String name = cursor.getString(nameIndex);

                    int numberIndex = cursor.getColumnIndex(CallLog.Calls.NUMBER);
                    String number = cursor.getString(numberIndex);

                    Log.i("call_log","姓名:"+name+" 电话:"+number);

                }while (cursor.moveToNext());
            }

            Toast.makeText(this, "读取成功", Toast.LENGTH_SHORT).show();
        });
    }

    private void initViews() {
        btn_call_log = findViewById(R.id.btn_call_log);
    }
}