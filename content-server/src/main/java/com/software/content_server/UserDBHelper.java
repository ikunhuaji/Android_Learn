package com.software.content_server;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 应用程序启动时加载
 * 创建或打开数据库
 */

public class UserDBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "user.db";
    public static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "user_info";
    private static UserDBHelper userDBHelper;
    private SQLiteDatabase read;
    private SQLiteDatabase write;

    private UserDBHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    //单例模式，懒汉模式-》饿汉模式
    //保证应用只有一个实例，只有 UserDBHelper ， 只有他才能操作 user.db 数据库
    //创建获取单例的函数
    public static UserDBHelper getInstance(Context context){
        return (userDBHelper!=null) ? userDBHelper : (userDBHelper = new UserDBHelper(context));
    }

    //读写连接方式
    public SQLiteDatabase openReadLink(){
        if(read == null || !read.isOpen()){
            read = userDBHelper.getReadableDatabase();
        }
        return read;
    }

    public SQLiteDatabase openWriteLink(){
        if(write == null|| !write.isOpen()){
            write = userDBHelper.getWritableDatabase();
        }
        return write;
    }

    //关闭连接
    public void closeLink(){
        if(read !=null || read.isOpen()){
            read.close();
            read = null;
        }
        if (write != null || write.isOpen()){
            write.close();
            write = null;
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS "+ TABLE_NAME +" ( "+
                " id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+
                " name VARCHAR NOT NULL, "+
                " age INT NOT NULL, "+
                " height INT NOT NULL, "+
                " weight FLOAT NOT NULL);";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
