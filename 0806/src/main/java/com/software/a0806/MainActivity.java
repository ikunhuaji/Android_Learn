package com.software.a0806;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_desc;
    private ImageView iv_icon;
    private EditText edt_string;
    private Button btn_check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        initEvent();
    }

    private void initEvent() {
        tv_desc.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int len = tv_desc.getText().toString().length();

                if(len>7 || len <1)
                {
                    iv_icon.setImageResource(R.mipmap.wrong);
                }
                else iv_icon.setImageResource(R.mipmap.ok);
            }
        });

        btn_check.setOnClickListener(v->{
            String s = edt_string.getText().toString();
            tv_desc.setText(s);
        });
    }

    private void initViews() {
        tv_desc = findViewById(R.id.tv_desc);
        iv_icon = findViewById(R.id.iv_icon);
        edt_string = findViewById(R.id.edt_string);
        btn_check = findViewById(R.id.btn_check);
    }
}