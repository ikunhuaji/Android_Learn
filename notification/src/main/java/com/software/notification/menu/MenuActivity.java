package com.software.notification.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;

import com.software.notification.R;
import com.software.notification.utils.ToastUtil;

public class MenuActivity extends AppCompatActivity {

    private EditText edt_paste;
    private EditText edt_copy;
    private Button btn_popupmenu;

    private final String TAG = "msg";
    private Button btn_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //初始化控件
        initView();

        //注册上下文菜单
        registerForContextMenu(edt_copy);
        registerForContextMenu(edt_paste);

        //绑定弹出菜单按钮事件
        btn_popupmenu.setOnClickListener(v->{
            //创建弹出式菜单
            PopupMenu popupMenu = new PopupMenu(MenuActivity.this,btn_popupmenu);//后面指在那个控件下弹出
            popupMenu.getMenuInflater().inflate(R.menu.menu_item, popupMenu.getMenu());//绑定菜单
            //绑定菜单点击事件
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    ToastUtil.show(MenuActivity.this,item.getTitle().toString());
                    return false;
                }
            });

            //显示菜单
            popupMenu.show();

        });

        btn_test.setOnLongClickListener(new View.OnLongClickListener() {//长按
            @Override
            public boolean onLongClick(View v) {
                Log.i(TAG,"长按");
                return false;
            }
        });

        btn_test.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if(action==MotionEvent.ACTION_DOWN) {
                    Log.i(TAG,"触摸上");

                }
                if (action==MotionEvent.ACTION_UP) {
                    Log.i(TAG, "失去触摸");
                }

                return false;
            }
        });
    }

    private void initView() {
        edt_copy = findViewById(R.id.edt_copy);
        edt_paste = findViewById(R.id.edt_paste);
        btn_popupmenu = findViewById(R.id.btn_popupmenu);
        btn_test = findViewById(R.id.btn_test);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //关联
        getMenuInflater().inflate(R.menu.menu_item,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        ToastUtil.show(this,item.getTitle().toString());
        return super.onOptionsItemSelected(item);
    }

    //上下文菜单
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_item,menu);

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        //获取系统剪切板
        ClipboardManager cm  = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

        //选择了复制菜单
        if(itemId==R.id.file_copy){
            //把edt_copy文本复制到剪切板
            cm.setPrimaryClip(ClipData.newPlainText("msg",edt_copy.getText().toString()));
            ToastUtil.show(MenuActivity.this,"复制成功");
        }
        if(itemId==R.id.file_paste){
            //把剪切板内容粘贴到edt_paste
            edt_paste.setText(cm.getPrimaryClip().getItemAt(0).getText());
        }
        return super.onContextItemSelected(item);
    }

    public  void handleClick(View view){
        Log.i(TAG,"弹起");
    }
}