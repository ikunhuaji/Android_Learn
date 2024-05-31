package com.software.homework2.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.software.homework2.Db.CartDb;
import com.software.homework2.R;
import com.software.homework2.activity.IntroActivity;
import com.software.homework2.activity.MainActivity;
import com.software.homework2.entity.Food;
import com.software.homework2.entity.Product;

import java.io.Serializable;
import java.util.List;

public class FoodAdapter extends BaseAdapter {

    private Context context;
    private Integer layoutId;
    private List<Food>foodList;

    public FoodAdapter(Context context,Integer layoutId,List<Food>foodList){
        this.context=context;
        this.layoutId=layoutId;
        this.foodList=foodList;
    }

    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Object getItem(int position) {
        return foodList.get(position);
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

        ImageView iv_food_img = convertView.findViewById(R.id.iv_food_image);
        TextView tv_food_name = convertView.findViewById(R.id.tv_food_name);
        TextView tv_food_intro = convertView.findViewById(R.id.tv_food_intro);
        TextView tv_food_price = convertView.findViewById(R.id.tv_food_price);

        Food food = foodList.get(position);

        iv_food_img.setImageResource(food.getFoodImage());
        tv_food_name.setText(food.getFoodName());
        tv_food_intro.setText(food.getFoodIntro());
        tv_food_price.setText(String.valueOf(food.getFoodPrice()));

        convertView.setOnClickListener(v->{
            Product product = new Product(food.getFoodImage(),food.getFoodName(),food.getFoodIntro(),food.getFoodPrice());

            Intent intent = new Intent(
                    parent.getContext(),
                    IntroActivity.class
            );

            Bundle bundle = new Bundle();
            bundle.putSerializable("product",product);
            intent.putExtras(bundle);

            parent.getContext().startActivity(intent);
        });

        return convertView;
    }


}
