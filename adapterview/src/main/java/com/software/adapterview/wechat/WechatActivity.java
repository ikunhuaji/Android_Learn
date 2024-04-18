package com.software.adapterview.wechat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.media.Image;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.software.adapterview.R;
import com.software.adapterview.adapters.WechatFragmentAdapter;
import com.software.adapterview.fragments.ContractFragment;
import com.software.adapterview.fragments.FindFragment;
import com.software.adapterview.fragments.MineFragment;
import com.software.adapterview.fragments.WechatFragment;

import java.util.ArrayList;
import java.util.List;

public class WechatActivity extends AppCompatActivity {

    private TabLayout tb_nav;
    private ViewPager2 vp_contest;
    private List<Fragment> fragmentList;
    private List<String> tabNameList;
    private List<Integer> tabImageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wechat);

        findViews();

        initFragments();

        WechatFragmentAdapter adapter = new WechatFragmentAdapter(
                fragmentList,
                this
        ) ;

        vp_contest.setAdapter(adapter);


        TabLayoutMediator mediator = new TabLayoutMediator(
                tb_nav,
                vp_contest,

                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                        tab.setText(tabNameList.get(position));
                        tab.setIcon(tabImageList.get(position));
                        
//                        switch (position){
//                            case 0:
//                                tab.setText("微信");
//                                tab.setIcon(R.mipmap.message);
//                                break;
//                            case 1:
//                                tab.setText("联系人");
//                                tab.setIcon(R.mipmap.contract);
//                                break;
//                            case 2:
//                                tab.setText("发现");
//                                tab.setIcon(R.mipmap.find);
//                                break;
//                            case 3:
//                                tab.setText("我的");
//                                tab.setIcon(R.mipmap.mine);
//                                break;
//
//                        }
                    }
                }
        );

        mediator.attach();
    }

    private void initFragments() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new WechatFragment());
        fragmentList.add(new ContractFragment());
        fragmentList.add(new FindFragment());
        fragmentList.add(new MineFragment());

        tabNameList = new ArrayList<>();
        tabNameList.add("微信");
        tabNameList.add("联系人");
        tabNameList.add("发现");
        tabNameList.add("我的");

        tabImageList = new ArrayList<>();
        tabImageList.add(R.mipmap.message);
        tabImageList.add(R.mipmap.contract);
        tabImageList.add(R.mipmap.find);
        tabImageList.add(R.mipmap.mine);
    }

    private void findViews(){
        tb_nav = findViewById(R.id.tb_nav);
        vp_contest = findViewById(R.id.vp_context);

    }
}