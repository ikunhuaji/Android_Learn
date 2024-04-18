package com.software.tablelayout.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.software.tablelayout.R;
import com.software.tablelayout.entity.Wechat;

import java.util.List;

//获取数据，对数据进行操作
public class WechatAdapter extends BaseAdapter {

    private Context context;
    private Integer layoutId;
    private List<Wechat> wechatList;

    public WechatAdapter(Context context,Integer layoutId,List<Wechat> wechatList){
        this.context=context;
        this.wechatList=wechatList;
        this.layoutId=layoutId;
    }

    //获取数据源中数据个数
    @Override
    public int getCount() {
        return wechatList.size();
    }

    //获取position下标数据
    @Override
    public Object getItem(int position) {
        return wechatList.get(position);
    }

    //返回数据下标位置
    @Override
    public long getItemId(int position) {
        return position;
    }

    //拿到一个未绑定数据的视图
    //绑定数据
    //返回绑定好数据的视图
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            //视图加载器
            convertView = LayoutInflater.from(this.context).inflate(layoutId,null);
        }

        //获取头像，昵称……
        ImageView iv_avatar = convertView.findViewById(R.id.iv_avatar);
        TextView tv_nickname = convertView.findViewById(R.id.tv_nickname);
        TextView tv_endmessage = convertView.findViewById(R.id.tv_endmessage);
        Wechat wechat = wechatList.get(position);
        iv_avatar.setImageResource(wechat.getAvatar());
        tv_nickname.setText(wechat.getNickname());
        tv_endmessage.setText(wechat.getEndMessage());

        return convertView;
    }
}
