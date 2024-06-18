package com.software.androidhomework.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.software.androidhomework.Dao.ProductDao;
import com.software.androidhomework.R;
import com.software.androidhomework.adapters.ProductAdapter;
import com.software.androidhomework.entity.Product;

import java.util.List;

public class ProductFragment extends Fragment {

    private View view;
    private List<Product> products;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_product,null);

        GridView gv_product = view.findViewById(R.id.gv_product);

        ((Activity)getContext()).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                products = ProductDao.products;
            }
        });

        ProductAdapter adapter = new ProductAdapter(
            this.getContext(),
            R.layout.item_product,
            products
        );

        gv_product.setAdapter(adapter);

        return view;
    }
}
