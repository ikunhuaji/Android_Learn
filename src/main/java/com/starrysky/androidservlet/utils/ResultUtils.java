package com.starrysky.androidservlet.utils;

import cn.hutool.json.JSONUtil;
public class ResultUtils {
    public static<T> String string(T data){
        return success("成功",data);
    }
    public static<T> String success(String msg,T data){
        return success(200,msg,data);
    }
    public static<T> String success(Integer code,String msg,T data){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);

        return JSONUtil.toJsonStr(result);
    }

    public static String error(String msg){
        return error(500,msg);
    }

    public static String error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);

//        result 转为 Json

        return JSONUtil.toJsonStr(result);
    }
}
