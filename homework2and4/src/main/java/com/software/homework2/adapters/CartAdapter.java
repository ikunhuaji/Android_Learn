package com.software.homework2.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.software.homework2.Db.CartDb;
import com.software.homework2.R;
import com.software.homework2.entity.BuyItem;
import com.software.homework2.entity.Food;
import com.software.homework2.entity.Product;

import java.util.List;

public class CartAdapter extends BaseAdapter {
    private Context context;
    private Integer layoutId;

    public CartAdapter(Context context, Integer layoutId) {
        this.context = context;
        this.layoutId = layoutId;
    }

    @Override
    public int getCount() {
        return CartDb.cartList.size();
    }

    @Override
    public Object getItem(int position) {
        return CartDb.cartList.get(position);
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

        ImageView iv_cart_image = convertView.findViewById(R.id.iv_cart_image);
        TextView tv_cart_name = convertView.findViewById(R.id.tv_cart_name);
        TextView tv_cart_intro = convertView.findViewById(R.id.tv_cart_intro);
        TextView tv_cart_price = convertView.findViewById(R.id.tv_cart_price);
        TextView tv_cart_add = convertView.findViewById(R.id.tv_cart_add);
        TextView tv_cart_reduce = convertView.findViewById(R.id.tv_cart_reduce);
        TextView tv_cart_cnt = convertView.findViewById(R.id.tv_cart_cnt);
        Button btn_cart_delete = convertView.findViewById(R.id.btn_cart_delete);

        BuyItem buyItem = CartDb.cartList.get(position);
        Product product = buyItem.product;

        iv_cart_image.setImageResource(product.getImage());
        tv_cart_name.setText(product.getName());
        tv_cart_intro.setText(product.getIntro());
        tv_cart_price.setText(String.valueOf(product.getPrice()));
        tv_cart_cnt.setText(String.valueOf(buyItem.cnt));

        tv_cart_add.setOnClickListener(v->{
            int cnt = CartDb.add(product,1);
            tv_cart_cnt.setText(String.valueOf(cnt));
        });

        tv_cart_reduce.setOnClickListener(v->{
            int cnt = Integer.parseInt(tv_cart_cnt.getText().toString());
            if(cnt==1)
            {
                CartDb.delete(product);
                notifyDataSetChanged();
            }
            else
            {
                cnt = CartDb.reduce(product);
                tv_cart_cnt.setText(String.valueOf(cnt));
            }
        });

        btn_cart_delete.setOnClickListener(v->{
            CartDb.delete(product);

            notifyDataSetChanged();

        });

        return convertView;
    }
}
