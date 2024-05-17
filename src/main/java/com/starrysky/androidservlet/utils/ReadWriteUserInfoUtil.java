package com.starrysky.androidservlet.utils;

import com.starrysky.androidservlet.entity.UserInfo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWriteUserInfoUtil {

    private static final String PATH = "E:\\new.text";
    public static void saveUserInfo(UserInfo userInfo){
        BufferedWriter bw = null;
        try{
            bw = new BufferedWriter(new FileWriter(PATH,true));
            String userInfoStr = String.format(
                    "%s;%s;%s",
                    userInfo.getPhone(),
                    userInfo.getPassword(),
                    userInfo.getAvatar()
            );

            bw.write(userInfoStr);
            bw.flush();
            bw.newLine();

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(bw!=null){
                try{
                    bw.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
