package com.software.kot2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tv_submit = findViewById<TextView>(R.id.tv_submit)
        var btn_submit = findViewById<Button>(R.id.btn_submit)

        btn_submit.setOnClickListener{
            tv_submit.text = "提交成功"
        }
    }
}