package com.software.sqlite.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.software.sqlite.entity.UserInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 应用程序启动时加载
 * 创建或打开数据库
 */

public class UserDBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "user.db";
    private static final int DB_VERSION = 2;
    private static final String TABLE_NAME = "user_info";
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
        //数据库版本变化时，应用程序安装执行此方法
        //更新数据库结构
//        String sql = "ALTER TABLE " + TABLE_NAME + " ADD COLUMN phone VARCHAR;";
//        execSql(sql);
    }

    public long insert(UserInfo userInfo){
        ContentValues values = new ContentValues();

        values.put("name",userInfo.getName());
        values.put("age",userInfo.getAge());
        values.put("height",userInfo.getHeight());
        values.put("weight",userInfo.getWeight());

        try {
            //开启事务

            write.beginTransaction();

            write.insert(TABLE_NAME,null,values);

            write.setTransactionSuccessful();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            write.endTransaction();
        }

        return 1;

//        return write.insert(TABLE_NAME,null,values);
    }

    public UserInfo queryById(String id) {
        // Curson 相当于 ResultSet
        Cursor cursor = read.query(TABLE_NAME, null, "id= ? ", new String[]{id}, null, null, null);

        if(cursor.moveToFirst())//能移动到第一行 相当于 result.next() 的判断但不移动
        {
            int idIndex = cursor.getColumnIndex("id");
            int dbId = cursor.getInt(idIndex);

            int nameIndex = cursor.getColumnIndex("name");
            String dbName = cursor.getString(nameIndex);

            int ageIndex = cursor.getColumnIndex("age");
            int dbAge = cursor.getInt(ageIndex);

            int heightIndex = cursor.getColumnIndex("height");
            int dbHeight = cursor.getInt(heightIndex);

            int weightIndex = cursor.getColumnIndex("weight");
            float dbWeight = cursor.getFloat(weightIndex);

            UserInfo userInfo = new UserInfo(dbId,dbName,dbAge,dbHeight,dbWeight);

            return userInfo;
        }

        return null;
    }

    public List<UserInfo> query() {
        List<UserInfo>userInfoList = new ArrayList<>();

        Cursor cursor = read.query(TABLE_NAME,null,null,null,null,null,null);

        if(cursor.moveToFirst()){
            do {
                int dbId = cursor.getInt(0);
                String dbName = cursor.getString(1);
                int dbAge = cursor.getInt(2);
                int dbHeight = cursor.getInt(3);
                float dbWeight = cursor.getFloat(4);

                UserInfo userInfo = new UserInfo(dbId,dbName,dbAge,dbHeight,dbWeight);

                userInfoList.add(userInfo);

            }while (cursor.moveToNext());
        }

        return userInfoList;
    }

    public long delete(String id) {
        return write.delete(TABLE_NAME,
                "id = ?",new String[]{id});
    }

    public long update(UserInfo userInfo) {
        ContentValues values = new ContentValues();
        //id 不要作为更新的值
        values.put("name",userInfo.getName());
        values.put("age",userInfo.getAge());
        values.put("height",userInfo.getHeight());
        values.put("weight",userInfo.getWeight());

        return write.update(TABLE_NAME,values,
                "id = ?",new String[]{String.valueOf(userInfo.getId())});
    }
}
