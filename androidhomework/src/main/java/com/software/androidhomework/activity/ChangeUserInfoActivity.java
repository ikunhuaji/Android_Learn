package com.software.androidhomework.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.software.androidhomework.R;
import com.software.androidhomework.entity.Result;
import com.software.androidhomework.entity.User;
import com.software.androidhomework.entity.UserInfo;
import com.software.androidhomework.utils.HostUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

public class ChangeUserInfoActivity extends AppCompatActivity {

    private EditText edt_change_avatar;
    private ImageView iv_change_avatar;
    private Button btn_change_avatar;
    private EditText edt_change_nickName;
    private EditText edt_change_email;
    private EditText edt_change_pwd;
    private Button btn_change_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_user_info);

        initViews();

        initEvents();
    }

    private void initEvents() {
        btn_change_avatar.setOnClickListener(v->{
            String url = edt_change_avatar.getText().toString();

            Glide.with(this)
                    .asBitmap()
                    .load(url)
                    .placeholder(R.mipmap.loading)
                    .error(R.mipmap.error)
                    .fallback(R.mipmap.empty)
                    .transform(new CircleCrop())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(iv_change_avatar);
        });

        btn_change_update.setOnClickListener(v->{
            new Thread(){
                @Override
                public void run() {

                    String userName = UserInfo.getUserName();
                    String pwd = pwd=edt_change_pwd.getText().toString();
                    String email=edt_change_email.getText().toString();
                    String nickName=edt_change_nickName.getText().toString();
                    int id = UserInfo.getId();
                    String avatar = edt_change_avatar.getText().toString();

//                    System.out.println(avatar);

                    if(avatar==null||avatar.equals(""))avatar=UserInfo.getAvatar();
                    if(nickName==null||nickName.equals(""))nickName=UserInfo.getNickName();
                    if(email==null||email.equals(""))email=UserInfo.getEmail();
                    if(pwd==null||pwd.equals(""))pwd=UserInfo.getPwd();

                    System.out.println(avatar);

                    update(userName,pwd,email,nickName,id,avatar);
                }
            }.start();
        });
    }

    private void update(String userName, String pwd, String email, String nickName, int id, String avatar) {
        InputStream is = null;

        try{
            URL url = new URL(HostUtil.HOST+"/updateUserInfo?userName="+userName+"&pwd="+pwd+"&email="+email+"&nickName="+nickName+"&id="+id+"&avatar="+ URLEncoder.encode(avatar,"UTF-8"));

            is=url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String json = br.readLine();
            Gson gson = new Gson();

            Result result = gson.fromJson(json,new TypeToken<Result<User>>(){}.getType());

            User user = (User) result.getData();
            UserInfo.update(user);

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(
                            ChangeUserInfoActivity.this,
                            result.getMsg(),
                            Toast.LENGTH_SHORT
                    ).show();
                    gotoShop();
                }
            });

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void gotoShop() {
        Intent intent = new Intent(
                ChangeUserInfoActivity.this,
                ShopActivity.class
        );
        startActivity(intent);
    }

    private void initViews() {
        edt_change_avatar = findViewById(R.id.edt_change_avatar);
        iv_change_avatar = findViewById(R.id.iv_change_avatar);
        btn_change_avatar = findViewById(R.id.btn_change_avatar);
        edt_change_nickName = findViewById(R.id.edt_change_nickName);
        edt_change_email = findViewById(R.id.edt_change_email);
        edt_change_pwd = findViewById(R.id.edt_change_pwd);
        btn_change_update = findViewById(R.id.btn_change_update);

        edt_change_avatar.setHint(UserInfo.getAvatar());

        Glide.with(this)
                .asBitmap()
                .load(UserInfo.getAvatar())
                .placeholder(R.mipmap.loading)
                .error(R.mipmap.error)
                .fallback(R.mipmap.empty)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(iv_change_avatar);

        edt_change_nickName.setHint(UserInfo.getNickName());
        edt_change_email.setHint(UserInfo.getEmail());
        edt_change_pwd.setHint(UserInfo.getPwd());
    }
}