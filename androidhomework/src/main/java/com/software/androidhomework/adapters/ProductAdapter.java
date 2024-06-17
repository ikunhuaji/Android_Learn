package com.software.androidhomework.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.software.androidhomework.R;
import com.software.androidhomework.activity.IntroActivity;
import com.software.androidhomework.entity.Product;

import java.util.List;

public class ProductAdapter extends BaseAdapter {
    private Context context;
    private Integer layoutId;
    private List<Product>products;

    public ProductAdapter(Context context, Integer layoutId, List<Product> products) {
        this.context = context;
        this.layoutId = layoutId;
        this.products = products;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView= LayoutInflater.from(this.context).inflate(layoutId,null);
        }

        ImageView iv_product_img = convertView.findViewById(R.id.iv_product_image);
        TextView tv_product_name = convertView.findViewById(R.id.tv_product_name);
        TextView tv_product_price = convertView.findViewById(R.id.tv_product_price);
        TextView tv_product_nowCnt = convertView.findViewById(R.id.tv_product_newCnt);

        Product product = products.get(position);

        Glide.with(convertView)
                .asBitmap()
                .load(product.getImg())
                .placeholder(R.mipmap.loading)
                .error(R.mipmap.error)
                .fallback(R.mipmap.empty)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .into(iv_product_img);

        tv_product_name.setText(product.getName());
        tv_product_price.setText(String.valueOf(product.getPrice()));
        tv_product_nowCnt.setText(String.valueOf(product.getNowCnt()));

        convertView.setOnClickListener(v->{
            Product productTmp = new Product(product.getName(),product.getPrice(),product.getNowCnt(),product.getImg());

            Intent intent = new Intent(
                    parent.getContext(),
                    IntroActivity.class
            );

            Bundle bundle = new Bundle();
            bundle.putSerializable("product",productTmp);

            intent.putExtras(bundle);
            parent.getContext().startActivity(intent);
        });

        return convertView;
    }
}
