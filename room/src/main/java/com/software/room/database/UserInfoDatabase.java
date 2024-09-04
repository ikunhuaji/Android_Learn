package com.software.room.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.software.room.dao.UserInfoDao;
import com.software.room.entity.UserInfo;

/**
 * 获得 UserInfoDao 的实例 和 UserInfoDataBase 的实例
 * 在 Activity 中打开关闭
 * 和 SQLiteOpenHelper 一样
 */

@Database(entities = {UserInfo.class},version = 1,exportSchema = false)
public abstract class UserInfoDatabase extends RoomDatabase {

    //使用规定格式写法
    //JAVA 编码规范的规定
    public abstract UserInfoDao getUserInfoDao();

    public static UserInfoDatabase userInfoDatabase;

    //获取UserInfoDatabase的实例，单例
    //room 不能在主线程操作数据库,因为数据库是一个耗时操作，实际项目使用异步
    public static UserInfoDatabase getInstance(Context context){
        if(userInfoDatabase == null){
            userInfoDatabase = Room.databaseBuilder(
                    context.getApplicationContext(),
                            UserInfoDatabase.class,
                            "user_info"
                    )
                    .allowMainThreadQueries().build();//主线程操作数据库
        }
        return userInfoDatabase;
    }
}
