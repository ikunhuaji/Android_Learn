package com.software.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.software.room.entity.UserInfo;

import java.util.List;

/**
 * 标记dao，让room可以进行增删改查
 */
@Dao
public interface UserInfoDao {
    @Insert
    void insert(UserInfo... userInfo);

    //用类名代替表名
    @Query("SELECT * FROM UserInfo")
    List<UserInfo> quaryAll();

    @Query("SELECT * FROM UserInfo WHERE id = :id")
    UserInfo queryByID(Integer id);

    //默认以主键为条件进行修改
    @Update
    void update(UserInfo... userInfo);

    @Delete
    void delete(UserInfo userInfo);

    //带参数的Quer可以执行sql语句
    @Query("DELETE FROM UserInfo")
    void deleteAll();
}
