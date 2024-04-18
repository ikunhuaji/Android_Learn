package com.software.adapterview.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.software.adapterview.R;
import com.software.adapterview.adapters.WechatAdapter;
import com.software.adapterview.entity.Wechat;
import com.software.adapterview.wechat.WechatActivity;

import java.util.List;

public class WechatFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wechat,null);

        ListView lv_wechat = view.findViewById(R.id.lv_wechat);

        List<Wechat> wechatList = Wechat.getWechatList();

        //适配器
        WechatAdapter adapter = new WechatAdapter(
                this.getContext(),
                R.layout.item_wechat,
                wechatList
        );
        //绑定
        lv_wechat.setAdapter(adapter);
        //点击事件
        lv_wechat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(
                        WechatFragment.this.getContext(),
                        wechatList.get(position).getNickname(),
                        Toast.LENGTH_LONG
                ).show();
            }
        });

        return view;
    }
}
