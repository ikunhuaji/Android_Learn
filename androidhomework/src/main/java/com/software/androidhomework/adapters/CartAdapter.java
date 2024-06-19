package com.software.androidhomework.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.software.androidhomework.Dao.CartDao;
import com.software.androidhomework.R;
import com.software.androidhomework.entity.Cart;
import com.software.androidhomework.entity.UserInfo;

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
        return CartDao.carts.size();
    }

    @Override
    public Object getItem(int position) {
        return CartDao.carts.get(position);
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

        ImageView iv_cart_img = convertView.findViewById(R.id.iv_cart_img);
        TextView tv_cart_name = convertView.findViewById(R.id.tv_cart_name);
        TextView tv_cart_price = convertView.findViewById(R.id.tv_cart_price);
        TextView tv_cart_add = convertView.findViewById(R.id.tv_cart_add);
        TextView tv_cart_cnt = convertView.findViewById(R.id.tv_cart_cnt);
        TextView tv_cart_reduce = convertView.findViewById(R.id.tv_cart_reduce);
        Button btn_cart_delete = convertView.findViewById(R.id.btn_cart_delete);

        Cart cart = CartDao.carts.get(position);

        Glide.with(convertView)
                .asBitmap()
                .load(cart.getImg())
                .placeholder(R.mipmap.loading)
                .error(R.mipmap.error)
                .fallback(R.mipmap.empty)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .into(iv_cart_img);

        tv_cart_name.setText(cart.getName());
        tv_cart_price.setText(String.valueOf(cart.getPrice()));
        tv_cart_cnt.setText(String.valueOf(cart.getCnt()));

        //添加
        tv_cart_add.setOnClickListener(v->{
            int cnt = cart.getCnt()+1;

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    CartDao.addCartCnt(cart);
                }
            });

            thread.start();

            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            CartDao.carts.get(position).setCnt(cnt);

            notifyDataSetChanged();
        });

        //减少
        tv_cart_reduce.setOnClickListener(v->{
            int cnt = cart.getCnt()-1;
            if(cnt==0){
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        CartDao.deleteCart(UserInfo.getUserName(),cart.getName());
                    }
                });

                thread.start();

                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                CartDao.deleteCart(UserInfo.getUserName(),cart.getName());

                CartDao.delete(cart);

                notifyDataSetChanged();
            }else {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        CartDao.reduceCartCnt(cart);
                    }
                });

                thread.start();

                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                CartDao.carts.get(position).setCnt(cnt);

                notifyDataSetChanged();
            }
        });

        //删除
        btn_cart_delete.setOnClickListener(v->{
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    CartDao.deleteCart(UserInfo.getUserName(),cart.getName());
                }
            });

            thread.start();

            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            CartDao.delete(cart);

            notifyDataSetChanged();
        });

        return convertView;
    }
}
