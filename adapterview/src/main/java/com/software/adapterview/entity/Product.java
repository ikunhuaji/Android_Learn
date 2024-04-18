package com.software.adapterview.entity;

import com.software.adapterview.R;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String productName;
    private Integer productImage;
    private Double productPrice;

    public Product() {
    }

    public Product(String productName, Integer productImage, Double productPrice) {
        this.productName = productName;
        this.productImage = productImage;
        this.productPrice = productPrice;
    }

    public static List<Product> getProductList(){
        List<Product>productList = new ArrayList<>();
        productList.add(new Product("华为", R.drawable.huawei,6299.00));
        productList.add(new Product("荣耀", R.drawable.rongyao,5299.00));
        productList.add(new Product("苹果", R.drawable.iphone,8299.00));
        productList.add(new Product("VIVO", R.drawable.vivo,3299.00));
        productList.add(new Product("OPPO", R.drawable.oppo,2299.00));
        productList.add(new Product("小米", R.drawable.xiaomi,1999.00));

        return productList;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductImage() {
        return productImage;
    }

    public void setProductImage(Integer productImage) {
        this.productImage = productImage;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }
}
