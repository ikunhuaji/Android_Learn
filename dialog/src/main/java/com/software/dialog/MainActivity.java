package com.software.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity{

    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        btn_1.setOnClickListener(v->{
            //普通对话框
            AlertDialog dialog = new AlertDialog.Builder(this)
                    .setIcon(R.mipmap.icon)//设置标题的图片
                    .setTitle("普通的对话框")//设置对话框的标题
                    .setMessage("我是对话框的内容")//设置对话框的内容
                    //设置对话框的按钮
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, "点击了取消按钮", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();//销毁对话框
                        }
                    })
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, "点击了确定的按钮", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    }).create();//setNegativeButton 与 setPositiveButton 位置不同
            dialog.show();
        });

        btn_2.setOnClickListener(v->{
            //列表对话框
            final String items[] = {"我是选项一", "我是选项二", "我是选项三", "我是选项四"};
            AlertDialog dialog = new AlertDialog.Builder(this)
                    .setIcon(R.mipmap.icon)//设置标题的图片
                    .setTitle("列表对话框")//设置对话框的标题
                    .setItems(items, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, items[which], Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, "点击了取消按钮", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    })
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, "点击了确定的按钮", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    }).create();
            dialog.show();
        });

        btn_3.setOnClickListener(v->{
            final String items[] = {"我是选项一", "我是选项二", "我是选项三", "我是选项四"};
            AlertDialog dialog = new AlertDialog.Builder(this)
                    .setIcon(R.mipmap.icon)//设置标题的图片
                    .setTitle("单选列表对话框")//设置对话框的标题
                    .setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, items[which], Toast.LENGTH_SHORT).show();
                        }
                    })//绑定单选选项，checkeditem为默认选中的下标，为 -1 则没有选择
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).create();
            dialog.show();

        });

        btn_4.setOnClickListener(v->{
            final String items[] = {"我是选项一", "我是选项二", "我是选项三", "我是选项四"};
            final boolean checkedItems[] = {true, false, true, false};
            AlertDialog dialog = new AlertDialog.Builder(this)
                    .setIcon(R.mipmap.icon)//设置标题的图片
                    .setTitle("多选对话框")//设置对话框的标题
                    .setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            checkedItems[which] = isChecked;
                        }
                    })
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            for (int i = 0; i < checkedItems.length; i++) {
                                if (checkedItems[i]) {
                                    Toast.makeText(MainActivity.this, "选中了" + i, Toast.LENGTH_SHORT).show();
                                }
                            }
                            dialog.dismiss();
                        }

                    }).create();

            dialog.show();
        });

        btn_5.setOnClickListener(v->{
            ProgressDialog dialog = new ProgressDialog(this);
            dialog.setMessage("正在加载中");
            dialog.show();
        });

        btn_6.setOnClickListener(v->{
            final ProgressDialog dialog = new ProgressDialog(this);
            dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);//设置水平进度条样式
            dialog.setMessage("正在加载中");
            dialog.setMax(100);//最大显示
            final Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                int progress = 0;

                @Override
                public void run() {
                    dialog.setProgress(progress += 5);
                    if (progress == dialog.getMax()) {
                        timer.cancel();
                    }
                }
            }, 0, 1000);//
            dialog.show();
        });
    }

    private void initView() {
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
    }
}