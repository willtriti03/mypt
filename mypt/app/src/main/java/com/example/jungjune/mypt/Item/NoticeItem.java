package com.example.jungjune.mypt.Item;

/**
 * Created by triti on 2017-07-25.
 */

public class NoticeItem {
    String name; String date; String to;
    public NoticeItem (String name, String date, String to){
        this.name=name;
        this.date=date;
        this.to=to;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getTo() {
        return to;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
