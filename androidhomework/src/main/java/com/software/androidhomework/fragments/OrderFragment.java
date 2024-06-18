package com.software.androidhomework.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.software.androidhomework.Dao.TotalBuyDao;
import com.software.androidhomework.R;
import com.software.androidhomework.adapters.OrderAdapter;
import com.software.androidhomework.entity.TotalBuy;
import com.software.androidhomework.entity.UserInfo;

import java.util.List;

public class OrderFragment extends Fragment {

    private View view;
    private List<TotalBuy> totalBuys;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_order,null);

        ListView lv_order = view.findViewById(R.id.lv_order);

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                totalBuys = TotalBuyDao.totalBuys;
            }
        });

        OrderAdapter adapter = new OrderAdapter(
                this.getContext(),
                R.layout.item_order,
                totalBuys
        );

        lv_order.setAdapter(adapter);

        return view;
    }
}
