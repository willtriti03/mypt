package com.example.jungjune.mypt.Item;

import java.util.ArrayList;

/**
 * Created by jungjune on 2017-07-23.
 */

public class WantedItem {
    ArrayList<String> imageList = new ArrayList<String>();
    String name;
    String introduce;
    String time;
    public WantedItem(ArrayList<String> arr, String name, String introduce,String time){
        this.imageList =arr;
        this.name = name;
        this.introduce = introduce;
        this.time= time;

    }

    public void setImageList(ArrayList<String> imageList) {
        this.imageList = imageList;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public ArrayList<String> getImageList() {
        return imageList;
    }

    public String getIntroduce() {
        return introduce;
    }

    public String getName() {
        return name;
    }
}
