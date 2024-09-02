package com.software.kot2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import java.net.URL

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tv_submit = findViewById<TextView>(R.id.tv_submit)
        var edt_image = findViewById<EditText>(R.id.edt_image)
        var btn_submit = findViewById<Button>(R.id.btn_submit)
        var iv_submit = findViewById<ImageView>(R.id.iv_submit)

        btn_submit.setOnClickListener{
            tv_submit.text = "提交成功"

            var url = edt_image.text.toString()

//            iv_submit.setImageResource(R.drawable.ikun)

            Glide.with(this)
                .asBitmap()
                .load(url)
                .into(iv_submit)
        }
    }
}