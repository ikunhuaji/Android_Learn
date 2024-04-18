package com.software.tablelayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.software.tablelayout.adapters.WechatAdapter;
import com.software.tablelayout.entity.Wechat;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tab_nav);

//        TextView tv_wechat= findViewById(R.id.tv_wechat);

        ListView lv_wechat = findViewById(R.id.lv_wechat);

        List<Wechat> wechatList = Wechat.getWechatList();

        //适配器
        WechatAdapter adapter = new WechatAdapter(
                this,
                R.layout.item_wechat,
                wechatList
        );
        //绑定
        lv_wechat.setAdapter(adapter);
        //点击事件
        lv_wechat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(
                        MainActivity.this,
                        wechatList.get(position).getNickname(),
                        Toast.LENGTH_LONG
                ).show();
            }
        });

        TextView tv_contract = findViewById(R.id.contract);
        TextView tv_find = findViewById(R.id.find);
        TextView tv_mine = findViewById(R.id.mine);

        //tablayout设置颜色
        int green = ContextCompat.getColor(this,R.color.green);
        int black = ContextCompat.getColor(this,R.color.black);

        tabLayout.setTabTextColors(black,green);

        //创建TAB
        TabLayout.Tab wechat = tabLayout.newTab();
        wechat.setIcon(R.mipmap.message);
        wechat.setText("微信");

        TabLayout.Tab contract = tabLayout.newTab();
        contract.setIcon(R.mipmap.contract);
        contract.setText("通讯录");

        TabLayout.Tab find = tabLayout.newTab();
        find.setIcon(R.mipmap.find);
        find.setText("发现");

        TabLayout.Tab mine = tabLayout.newTab();
        mine.setIcon(R.mipmap.mine);
        mine.setText("我的");

        tabLayout.addTab(wechat);
        tabLayout.addTab(contract);
        tabLayout.addTab(find);
        tabLayout.addTab(mine);

        wechat.setIcon(R.mipmap.msg);
        find.setIcon(R.mipmap.find);
        contract.setIcon(R.mipmap.contract);
        mine.setIcon(R.mipmap.mine);
//        tv_wechat.setVisibility(View.VISIBLE);
        lv_wechat.setVisibility(View.VISIBLE);

        tv_contract.setVisibility(View.INVISIBLE);
        tv_find.setVisibility(View.INVISIBLE);
        tv_mine.setVisibility(View.INVISIBLE);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();

                switch (position)
                {
                    case 0:
                        wechat.setIcon(R.mipmap.msg);
                        find.setIcon(R.mipmap.find);
                        contract.setIcon(R.mipmap.contract);
                        mine.setIcon(R.mipmap.mine);
//                        tv_wechat.setVisibility(View.VISIBLE);
                        lv_wechat.setVisibility(View.VISIBLE);

                        tv_contract.setVisibility(View.INVISIBLE);
                        tv_find.setVisibility(View.INVISIBLE);
                        tv_mine.setVisibility(View.INVISIBLE);
                        break;

                    case 1:
                        wechat.setIcon(R.mipmap.message);
                        find.setIcon(R.mipmap.find);
                        contract.setIcon(R.mipmap.contract_green);
                        mine.setIcon(R.mipmap.mine);
//                        tv_wechat.setVisibility(View.INVISIBLE);
                        lv_wechat.setVisibility(View.INVISIBLE);

                        tv_contract.setVisibility(View.VISIBLE);
                        tv_find.setVisibility(View.INVISIBLE);
                        tv_mine.setVisibility(View.INVISIBLE);
                        break;
                    case 2:
                        wechat.setIcon(R.mipmap.message);
                        find.setIcon(R.mipmap.fd);
                        contract.setIcon(R.mipmap.contract);
                        mine.setIcon(R.mipmap.mine);
//                        tv_wechat.setVisibility(View.INVISIBLE);
                        lv_wechat.setVisibility(View.INVISIBLE);

                        tv_contract.setVisibility(View.INVISIBLE);
                        tv_find.setVisibility(View.VISIBLE);
                        tv_mine.setVisibility(View.INVISIBLE);
                        break;

                    case 3:
                        wechat.setIcon(R.mipmap.message);
                        find.setIcon(R.mipmap.find);
                        contract.setIcon(R.mipmap.contract);
                        mine.setIcon(R.mipmap.mmine);
//                        tv_wechat.setVisibility(View.INVISIBLE);
                        lv_wechat.setVisibility(View.INVISIBLE);

                        tv_contract.setVisibility(View.INVISIBLE);
                        tv_find.setVisibility(View.INVISIBLE);
                        tv_mine.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }


        });
    }
}