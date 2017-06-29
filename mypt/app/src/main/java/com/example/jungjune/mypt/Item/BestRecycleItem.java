package com.example.jungjune.mypt.Item;

/**
 * Created by jungjune on 2017-06-29.
 */

public class BestRecycleItem {
    int image;
    String name;
    String info;
    public BestRecycleItem(){}

    public BestRecycleItem(int image, String name, String info){
        this.image = image;
        this.name = name;
        this.info = info;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }
}