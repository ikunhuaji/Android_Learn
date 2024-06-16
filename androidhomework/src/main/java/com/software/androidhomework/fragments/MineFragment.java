package com.software.androidhomework.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.software.androidhomework.R;
import com.software.androidhomework.entity.UserInfo;

public class MineFragment extends Fragment {

    private View view;
    private Button btn_change;
    private TextView tv_nickName;
    private ImageView iv_avatar;
    private TextView tv_userName;
    private TextView tv_email;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mine,null);

        initViews();

        initEvents();

        return  view;
    }

    private void initEvents() {
        btn_change.setOnClickListener(v->{

        });
    }

    private void initViews() {
        tv_nickName = view.findViewById(R.id.tv_nickName);
        iv_avatar = view.findViewById(R.id.iv_avatar);
        tv_userName = view.findViewById(R.id.tv_userName);
        tv_email = view.findViewById(R.id.tv_email);
        btn_change = view.findViewById(R.id.btn_change_info);

        tv_nickName.setText(UserInfo.nickName);

        Glide.with(this)
                .asBitmap()
                .load(UserInfo.avatar)
                .placeholder(R.mipmap.loading)
                .error(R.mipmap.error)
                .fallback(R.mipmap.empty)
                .transform(new CircleCrop())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(iv_avatar);

        tv_userName.setText(UserInfo.userName);
        tv_email.setText(UserInfo.email);
    }
}
