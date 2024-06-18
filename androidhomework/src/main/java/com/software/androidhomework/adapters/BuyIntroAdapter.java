package com.software.androidhomework.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.software.androidhomework.R;
import com.software.androidhomework.entity.Buy;

import java.util.List;

public class BuyIntroAdapter extends BaseAdapter {

    private Context context;
    private Integer layoutId;
    private List<Buy> buys;

    public BuyIntroAdapter(Context context, Integer layoutId, List<Buy> buys) {
        this.context = context;
        this.layoutId = layoutId;
        this.buys = buys;
    }

    @Override
    public int getCount() {
        return buys.size();
    }

    @Override
    public Object getItem(int position) {
        return buys.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = LayoutInflater.from(this.context).inflate(layoutId,null);
        }

        Buy buy = buys.get(position);

        ImageView iv_buy_img = convertView.findViewById(R.id.iv_buy_img);
        TextView tv_buy_name = convertView.findViewById(R.id.tv_buy_name);
        TextView tv_buy_price = convertView.findViewById(R.id.tv_buy_price);
        TextView tv_buy_cnt = convertView.findViewById(R.id.tv_buy_cnt);

        Glide.with(convertView)
                .asBitmap()
                .load(buy.getImg())
                .placeholder(R.mipmap.loading)
                .error(R.mipmap.error)
                .fallback(R.mipmap.empty)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .into(iv_buy_img);

        tv_buy_name.setText(buy.getName());
        tv_buy_price.setText(String.valueOf(buy.getPrice()));
        tv_buy_cnt.setText(String.valueOf(buy.getCnt()));

        return convertView;
    }
}
