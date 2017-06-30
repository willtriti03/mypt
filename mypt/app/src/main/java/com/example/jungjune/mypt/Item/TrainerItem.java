package com.example.jungjune.mypt.Item;

import android.graphics.drawable.Drawable;

/**
 * Created by jungjune on 2017-06-30.
 */

public class TrainerItem {
    int money,like, star;
    boolean best;

    String name,location;
    Drawable dw;

    public void setDw(Drawable dw) {
        this.dw = dw;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setBest(boolean best) {
        this.best = best;
    }

    public Drawable getDw() {
        return dw;
    }

    public int getMoney() {
        return money;
    }

    public int getLike() {
        return like;
    }

    public int getStar() {
        return star;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
    public boolean getBest(){
        return best;
    }

}
