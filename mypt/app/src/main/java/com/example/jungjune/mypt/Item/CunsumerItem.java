package com.example.jungjune.mypt.Item;

/**
 * Created by triti on 2017-07-18.
 */

public class CunsumerItem {
    String height,weight,oneTime,time,location;

    public CunsumerItem(String height,String weight,String oneTime,String time,String location){
        this.weight=weight;
        this.height=height;
        this.oneTime=oneTime;
        this.time=time;
        this.location=location;
    }
    public void setHeight(String height) {
        this.height = height;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setOneTime(String oneTime) {
        this.oneTime = oneTime;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public String getTime() {
        return time;
    }

    public String getOneTime() {
        return oneTime;
    }

    public String getLocation() {
        return location;
    }
}
