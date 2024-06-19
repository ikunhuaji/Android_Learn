package com.software.androidhomework.fragments;

import android.content.Intent;
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
import com.software.androidhomework.Dao.CartDao;
import com.software.androidhomework.R;
import com.software.androidhomework.activity.CartActivity;
import com.software.androidhomework.activity.ChangeUserInfoActivity;
import com.software.androidhomework.activity.ShopActivity;
import com.software.androidhomework.entity.Cart;
import com.software.androidhomework.entity.UserInfo;

public class MineFragment extends Fragment {

    private View view;
    private Button btn_change;
    private TextView tv_nickName;
    private ImageView iv_avatar;
    private TextView tv_userName;
    private TextView tv_email;
    private Button btn_mine_cart;

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
            Intent intent = new Intent(
                    getContext(),
                    ChangeUserInfoActivity.class
            );

            startActivity(intent);
        });

        btn_mine_cart.setOnClickListener(v->{

            Intent intent = new Intent(
                    getContext(),
                    CartActivity.class
            );

            startActivity(intent);
        });
    }

    private void initViews() {
        tv_nickName = view.findViewById(R.id.tv_nickName);
        iv_avatar = view.findViewById(R.id.iv_avatar);
        tv_userName = view.findViewById(R.id.tv_userName);
        tv_email = view.findViewById(R.id.tv_email);
        btn_mine_cart = view.findViewById(R.id.btn_mine_cart);
        btn_change = view.findViewById(R.id.btn_change_info);

        tv_nickName.setText(UserInfo.getNickName());

        Glide.with(this)
                .asBitmap()
                .load(UserInfo.getAvatar())
                .placeholder(R.mipmap.loading)
                .error(R.mipmap.error)
                .fallback(R.mipmap.empty)
                .transform(new CircleCrop())
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .into(iv_avatar);

        tv_userName.setText(UserInfo.getUserName());
        tv_email.setText(UserInfo.getEmail());
    }
}
