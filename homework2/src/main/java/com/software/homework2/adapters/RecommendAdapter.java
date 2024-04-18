package com.software.homework2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.software.homework2.R;
import com.software.homework2.entity.Recommend;

import java.util.List;

public class RecommendAdapter extends BaseAdapter {

    private Context context;
    private Integer layoutId;
    private List<Recommend> recommendList;

    public RecommendAdapter(Context context, Integer layoutId, List<Recommend> recommendList){
        this.context=context;
        this.layoutId=layoutId;
        this.recommendList = recommendList;
    }


    @Override
    public int getCount() {
        return recommendList.size();
    }

    @Override
    public Object getItem(int position) {
        return recommendList.get(position);
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
        ImageView iv_recommend_img = convertView.findViewById(R.id.iv_recommend_image);
        TextView tv_recommend_name = convertView.findViewById(R.id.tv_recommend_name);
        TextView tv_recommend_intro = convertView.findViewById(R.id.tv_recommend_intro);
        TextView tv_recommend_price = convertView.findViewById(R.id.tv_recommend_price);

        Recommend recommend = recommendList.get(position);

        iv_recommend_img.setImageResource(recommend.getRecommendImage());
        tv_recommend_name.setText(recommend.getRecommendName());
        tv_recommend_intro.setText(recommend.getRecommendIntro());
        tv_recommend_price.setText(String.valueOf(recommend.getRecommendPrice()));

        return convertView;
    }
}
