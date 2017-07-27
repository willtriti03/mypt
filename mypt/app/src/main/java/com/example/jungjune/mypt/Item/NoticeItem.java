package com.example.jungjune.mypt.Item;

/**
 * Created by triti on 2017-07-25.
 */

public class NoticeItem {
    String name; String date; String to,text;
    public NoticeItem (String name, String date, String text,String to){
        this.name=name;
        this.date=date;
        this.text=text;
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

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
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
