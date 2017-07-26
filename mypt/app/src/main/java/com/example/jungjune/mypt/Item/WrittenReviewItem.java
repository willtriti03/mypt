package com.example.jungjune.mypt.Item;


/**
 * Created by jungjune on 2017-07-26.
 */

public class WrittenReviewItem {
    String image;
    String name;
    String introduce;
    String time;
    String to;
    public WrittenReviewItem(String image,String name, String introduce,String time,String to){
        this.image=image;
        this.name = name;
        this.introduce = introduce;
        this.time= time;
        this.to =to;

    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setImage(String image) {
        this.image = image;
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

    public String getTo() {
        return to;
    }

    public String getIntroduce() {
        return introduce;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }
}
