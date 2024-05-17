package com.starrysky.androidservlet.servlet;

import cn.hutool.crypto.digest.MD5;
import cn.hutool.json.JSONUtil;
import com.starrysky.androidservlet.entity.UserInfo;
import com.starrysky.androidservlet.utils.ReadWriteUserInfoUtil;
import com.starrysky.androidservlet.utils.Result;
import com.starrysky.androidservlet.utils.ResultUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/json;charset=utf-8");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        PrintWriter os = response.getWriter();

        //判定
        if(phone==null||"".equals(phone)){
            os.write(ResultUtils.error("手机号不能为空"));
        }else if(password==null||"".equals(password)){
            os.write(ResultUtils.error("密码不能为空"));
        }else{
            //加密密码
            String hex16 = MD5.create().digestHex16(password);
            UserInfo userInfo = new UserInfo();
            userInfo.setPhone(phone);
            userInfo.setPassword(hex16);
            //userInfo 写到文件中
            ReadWriteUserInfoUtil.saveUserInfo(userInfo);
            os.write(ResultUtils.success("注册成功",userInfo));
        }
    }
}
