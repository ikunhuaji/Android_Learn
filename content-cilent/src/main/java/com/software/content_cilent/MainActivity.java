package com.software.content_cilent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn_call_log;
    private Button btn_insert;
    private Button btn_query;
    private ContentResolver resolver;

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
            resolver = getContentResolver();
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

        btn_insert.setOnClickListener(v->{
            resolver = getContentResolver();
            String uriStr = "content://com.software.content_server.UserInfoContentProvider/user_info";

            Uri uri = Uri.parse(uriStr);

            UserInfoObserver observer = new UserInfoObserver(null);
            resolver.registerContentObserver(uri,true,observer);

            ContentValues values = new ContentValues();
            values.put("name","张三");
            values.put("age","18");
            values.put("height","180");
            values.put("weight","80F");
            Uri inserted = resolver.insert(uri,values);
            long row = ContentUris.parseId(inserted);

            if(row>0){
                Log.i("user_info","插入成功");
                Toast.makeText(this, "插入成功", Toast.LENGTH_SHORT).show();
            }
        });

        btn_query.setOnClickListener(v -> {
            resolver = getContentResolver();
            String uriStr = "content://com.software.content_server.UserInfoContentProvider/user_info";

            Uri uri = Uri.parse(uriStr);
            Cursor cursor = resolver.query(uri,null,null,null,null);

            if (cursor.moveToFirst()){
                do {
                    String name = cursor.getString(1);
                    Integer age = cursor.getInt(2);

                    Log.i("user_info","name:"+name+" age:"+age);
                }while (cursor.moveToNext());
            }

            Toast.makeText(this, "查询成功", Toast.LENGTH_SHORT).show();
        });
    }

    private void initViews() {
        btn_call_log = findViewById(R.id.btn_call_log);
        btn_insert = findViewById(R.id.btn_insert);
        btn_query = findViewById(R.id.btn_query);
    }
}