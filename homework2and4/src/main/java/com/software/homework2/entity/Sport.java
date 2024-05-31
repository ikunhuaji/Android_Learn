package com.software.homework2.entity;

import com.software.homework2.R;

import java.util.ArrayList;
import java.util.List;

public class Sport {
    private Integer sportImage;
    private String sportName;
    private String sportIntro;
    private Double sportPrice;

    public Sport() {
    }

    public Sport(Integer sportImage, String sportName, String sportIntro, Double sportPrice) {
        this.sportImage = sportImage;
        this.sportName = sportName;
        this.sportIntro = sportIntro;
        this.sportPrice = sportPrice;
    }

    public static List<Sport> getSportList(){
        List<Sport>sportList = new ArrayList<>();
        sportList.add(new Sport(R.drawable.tabletennis,"乒乓球拍","京东发货 旗舰店",373.0));
        sportList.add(new Sport(R.drawable.basketball,"篮球","月销1000+",149.0));
        sportList.add(new Sport(R.drawable.yumaoqiu,"羽毛球","极速发货 无理由退款",179.0));
        sportList.add(new Sport(R.drawable.football,"足球","月销2000",67.9));

        return sportList;
    }

    public Integer getSportImage() {
        return sportImage;
    }

    public void setSportImage(Integer sportImage) {
        this.sportImage = sportImage;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getSportIntro() {
        return sportIntro;
    }

    public void setSportIntro(String sportIntro) {
        this.sportIntro = sportIntro;
    }

    public Double getSportPrice() {
        return sportPrice;
    }

    public void setSportPrice(Double sportPrice) {
        this.sportPrice = sportPrice;
    }
}
