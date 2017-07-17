package com.example.jungjune.mypt.Item;

import android.graphics.drawable.Drawable;

/**
 * Created by jungjune on 2017-07-17.
 */

public class ImageSlideItem {
    int image;
    String path;

    public  ImageSlideItem(int im){
        image=im;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getImage() {
        return image;
    }
}
