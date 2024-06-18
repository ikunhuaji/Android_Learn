package com.software.androidhomework.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.software.androidhomework.Dao.BuyDao;
import com.software.androidhomework.R;
import com.software.androidhomework.activity.BuyIntroActivity;
import com.software.androidhomework.entity.TotalBuy;

import java.util.ArrayList;
import java.util.List;

public class OrderAdapter extends BaseAdapter {
    private Context context;
    private Integer layoutId;
    private List<TotalBuy>totalBuys = new ArrayList<>();

    public OrderAdapter(Context context, Integer layoutId, List<TotalBuy> totalBuys) {
        this.context = context;
        this.layoutId = layoutId;
        this.totalBuys = totalBuys;
    }

    @Override
    public int getCount() {
        return totalBuys.size();
    }

    @Override
    public Object getItem(int position) {
        return totalBuys.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(this.context).inflate(layoutId,null);
        }

        TextView tv_order_buyTime = convertView.findViewById(R.id.tv_order_buyTime);
        TextView tv_order_totalPrice = convertView.findViewById(R.id.tv_order_totalPrice);

        TotalBuy totalBuy = totalBuys.get(position);

        tv_order_buyTime.setText(totalBuy.getBuyTime());
        tv_order_totalPrice.setText(String.valueOf(totalBuy.getTotalPrice()));

        convertView.setOnClickListener(v->{
            Intent intent = new Intent(
                    parent.getContext(),
                    BuyIntroActivity.class
            );

            ((Activity)context).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    BuyDao.getBuys(totalBuy.getUserName(),totalBuy.getBuyTime());
                }
            });

            Bundle bundle = new Bundle();
            bundle.putSerializable("totalBuy",totalBuy);
            intent.putExtras(bundle);

            parent.getContext().startActivity(intent);
        });

        return convertView;
    }
}
