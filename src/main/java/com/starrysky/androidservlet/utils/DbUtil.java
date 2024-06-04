package com.starrysky.androidservlet.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DbUtil {

    private static Properties properties;

    //加载sql
    static {
        //加载驱动
        try{

            InputStream inputStream = DbUtil.class.getResourceAsStream("/jdbc.properties");
            properties = new Properties();

            properties.load(inputStream);

            Class.forName(properties.getProperty("jdbc.driverClassName"));
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //连接sql
    public static Connection getCon(){
        try {
            //获取数据库连接
            Connection con = DriverManager.getConnection(properties.getProperty("jdbc.url"),
                    properties.getProperty("jdbc.username"),
                    properties.getProperty("jdbc.password")
            );

            return con;

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    //关闭
    public static void close(ResultSet rs, PreparedStatement pstm,Connection con){
        try {
            if(rs!=null){
                rs.close();
            }
            if(pstm!=null){
                pstm.close();
            }
            if(con!=null){
                con.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //查找
    public static ResultSet executeQuery(PreparedStatement pstm,String sql){
        try{
            ResultSet rs = pstm.executeQuery(sql);

            return rs;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    //插入更新
    public static void execute(PreparedStatement pstm){
        try{
            pstm.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
