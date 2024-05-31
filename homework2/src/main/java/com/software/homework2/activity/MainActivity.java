package com.software.homework2.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.software.homework2.R;
import com.software.homework2.adapters.MainFragmentAdapter;
import com.software.homework2.fragments.FoodFragment;
import com.software.homework2.fragments.RecommendFragment;
import com.software.homework2.fragments.SportFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tb_nav;
    private ViewPager2 vp_context;
    private List<Fragment> fragmentList;
    private List<String> tabNameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();

        initFragments();

        MainFragmentAdapter adapter = new MainFragmentAdapter(
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
        fragmentList.add(new RecommendFragment());
        fragmentList.add(new FoodFragment());
        fragmentList.add(new SportFragment());

        tabNameList = new ArrayList<>();
        tabNameList.add("推荐");
        tabNameList.add("食品");
        tabNameList.add("运动");
    }

    private void findView() {
        tb_nav = findViewById(R.id.tb_nav);
        vp_context = findViewById(R.id.vp_context);
    }
}