package com.software.homework2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.software.homework2.R;
import com.software.homework2.entity.Sport;

import java.util.List;

public class SportAdapter extends BaseAdapter {

    private Context context;
    private Integer layoutId;
    private List<Sport>sportList;

    public SportAdapter(Context context, Integer layoutId, List<Sport> sportList) {
        this.context = context;
        this.layoutId = layoutId;
        this.sportList = sportList;
    }

    @Override
    public int getCount() {
        return sportList.size();
    }

    @Override
    public Object getItem(int position) {
        return sportList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView= LayoutInflater.from(this.context).inflate(layoutId,null);
        }

        ImageView iv_sport_img = convertView.findViewById(R.id.iv_sport_image);
        TextView tv_sport_name = convertView.findViewById(R.id.tv_sport_name);
        TextView tv_sport_intro = convertView.findViewById(R.id.tv_sport_intro);
        TextView tv_sport_price = convertView.findViewById(R.id.tv_sport_price);

        Sport sport = sportList.get(position);

        iv_sport_img.setImageResource(sport.getSportImage());
        tv_sport_name.setText(sport.getSportName());
        tv_sport_intro.setText(sport.getSportIntro());
        tv_sport_price.setText(String.valueOf(sport.getSportPrice()));

        return convertView;
    }
}
