package com.software.homework2.entity;

import com.software.homework2.R;

import java.util.ArrayList;
import java.util.List;

public class Recommend {
    private Integer recommendImage;
    private String recommendName;
    private String recommendIntro;
    private Double recommendPrice;

    public Recommend(){
    }

    public Recommend(Integer recommendImage,String recommendName,String recommendIntro,Double recommendPrice){
        this.recommendImage=recommendImage;
        this.recommendName=recommendName;
        this.recommendIntro=recommendIntro;
        this.recommendPrice=recommendPrice;
    }

    public static List<Recommend> getRecommendList(){
        List<Recommend>recommendList = new ArrayList<>();
        recommendList.add(new Recommend(R.drawable.huawei,"华为","退货包运费 极速退款",6299.00));
        recommendList.add(new Recommend(R.drawable.iphone,"苹果","月销1400 好评90%",8299.00));
        recommendList.add(new Recommend(R.drawable.vivo,"VIVO","退货包运费 极速退款",3299.00));
        recommendList.add(new Recommend(R.drawable.xiaomi,"小米","包邮",2299.00));
        recommendList.add(new Recommend(R.drawable.oppo,"OPPO","退货包运费 极速退款",3299.00));
        recommendList.add(new Recommend(R.drawable.rongyao,"荣耀","月销1000",4299.00));

        return recommendList;
    }

    public Integer getRecommendImage() {
        return recommendImage;
    }

    public void setRecommendImage(Integer recommendImage) {
        this.recommendImage = recommendImage;
    }

    public String getRecommendName() {
        return recommendName;
    }

    public void setRecommendName(String recommendName) {
        this.recommendName = recommendName;
    }

    public String getRecommendIntro() {
        return recommendIntro;
    }

    public void setRecommendIntro(String recommendIntro) {
        this.recommendIntro = recommendIntro;
    }

    public Double getRecommendPrice() {
        return recommendPrice;
    }

    public void setRecommendPrice(Double recommendPrice) {
        this.recommendPrice = recommendPrice;
    }
}
