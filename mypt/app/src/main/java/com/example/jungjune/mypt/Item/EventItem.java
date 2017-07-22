package com.example.jungjune.mypt.Item;

/**
 * Created by jungjune on 2017-07-23.
 */

public class EventItem  {
    String path, name, date;
    public  EventItem(String path, String name, String date){
        this.path =path;
        this.name=name;
        this.date=date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }
}

