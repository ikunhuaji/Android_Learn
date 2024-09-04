package com.software.room;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edt_name;
    private EditText edt_age;
    private EditText edt_height;
    private EditText edt_weight;
    private Button btn_insert;
    private EditText edt_find_id;
    private Button btn_find_id;
    private Button btn_query;
    private EditText edt_delete_id;
    private Button btn_delete_id;
    private Button btn_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        initEvents();
    }

    private void initEvents() {

    }

    private void initViews() {
        edt_name = findViewById(R.id.edt_name);
        edt_age = findViewById(R.id.edt_age);
        edt_height = findViewById(R.id.edt_height);
        edt_weight = findViewById(R.id.edt_weight);

        btn_insert = findViewById(R.id.btn_insert);

        edt_find_id = findViewById(R.id.edt_find_id);
        btn_find_id = findViewById(R.id.btn_find_id);

        btn_query = findViewById(R.id.btn_query);

        edt_delete_id = findViewById(R.id.edt_delete_id);
        btn_delete_id = findViewById(R.id.btn_delete_id);

        btn_update = findViewById(R.id.btn_update);
    }
}