package com.software.androidhomework.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.software.androidhomework.R;
import com.software.androidhomework.adapters.ShopAdapter;
import com.software.androidhomework.fragments.MineFragment;
import com.software.androidhomework.fragments.ProductFragment;

import java.util.ArrayList;
import java.util.List;

public class ShopActivity extends AppCompatActivity {

    private TabLayout tb_nav;
    private ViewPager2 vp_context;
    private List<Fragment> fragmentList;
    private List<String> tabNameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        initViews();

        initFragments();

        ShopAdapter adapter = new ShopAdapter(
                fragmentList,
                this
        );

        vp_context.setAdapter(adapter);

        TabLayoutMediator mediator = new TabLayoutMediator(
                tb_nav,
                vp_context,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        tab.setText(tabNameList.get(position));
                    }
                }
        );
        mediator.attach();
    }

    private void initFragments() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new ProductFragment());
        fragmentList.add(new MineFragment());

        tabNameList = new ArrayList<>();
        tabNameList.add("商品");
        tabNameList.add("我的");
    }

    private void initViews() {
        tb_nav = findViewById(R.id.tb_nav);
        vp_context = findViewById(R.id.vp_context);
    }
}