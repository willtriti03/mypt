package com.example.jungjune.mypt.Item;

import android.graphics.drawable.Drawable;

/**
 * Created by jungjune on 2017-07-14.
 */

public class MyPageItem {
    String content;
    Drawable img;
    String to;
    public MyPageItem(Drawable image, String con, String t){
        img=image;
        content=con;
        to=t;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Drawable getImg() {
        return img;
    }

    public String getContent() {
        return content;
    }

    public String getTo() {
        return to;
    }
}
