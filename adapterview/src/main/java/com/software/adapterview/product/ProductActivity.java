package com.software.adapterview.product;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.software.adapterview.R;
import com.software.adapterview.adapters.ProductAdapter;
import com.software.adapterview.entity.Product;

import java.util.List;

public class ProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        GridView gv_product = findViewById(R.id.gv_product);
        //获取数据
        List<Product>productList = Product.getProductList();

        ProductAdapter adapter = new ProductAdapter(
                this,
                R.layout.item_product,
                productList
        );
        gv_product.setAdapter(adapter);


    }
}