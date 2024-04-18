package com.software.homework2.entity;

import com.software.homework2.R;

import java.util.ArrayList;
import java.util.List;

public class Food {

    private Integer foodImage;
    private String foodName;
    private String foodIntro;
    private Double foodPrice;

    public Food(){}

    public Food(Integer foodImage,String foodName,String foodIntro,Double foodPrice){
        this.foodImage=foodImage;
        this.foodName=foodName;
        this.foodIntro=foodIntro;
        this.foodPrice=foodPrice;
    }

    public static List<Food> getFoodList(){
        List<Food>foodList = new ArrayList<>();
        foodList.add(new Food(R.drawable.sausage,"腊肠","退货包运费 极速退款",59.9));
        foodList.add(new Food(R.drawable.shell,"蛏子","月销500 好评94%",14.8));
        foodList.add(new Food(R.drawable.salmon,"三文鱼","月销100 旗舰店",149.0));
        foodList.add(new Food(R.drawable.mushroom,"野生榛蘑","月销100 无理由退换",39.0));
        foodList.add(new Food(R.drawable.tofu,"包浆豆腐","京东配送 无理由退换",17.9));
        foodList.add(new Food(R.drawable.lajiao,"辣椒","月销1000",11.8));

        return foodList;
    }

    public Integer getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(Integer foodImage) {
        this.foodImage = foodImage;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodIntro() {
        return foodIntro;
    }

    public void setFoodIntro(String foodIntro) {
        this.foodIntro = foodIntro;
    }

    public Double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(Double foodPrice) {
        this.foodPrice = foodPrice;
    }
}
