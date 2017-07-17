package com.example.jungjune.mypt.Item;

import android.graphics.drawable.Drawable;

/**
 * Created by jungjune on 2017-07-17.
 */

public class ImageSlideItem {
    Drawable image;
    String path;

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public Drawable getImage() {
        return image;
    }
}
