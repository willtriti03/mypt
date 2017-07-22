package com.example.jungjune.mypt.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jungjune.mypt.Item.EventItem;
import com.example.jungjune.mypt.Item.MyPageItem;
import com.example.jungjune.mypt.R;

import java.util.ArrayList;

/**
 * Created by jungjune on 2017-07-23.
 */

public class EventAdapter extends BaseAdapter {
    private ArrayList<EventItem> listViewItemList = new ArrayList<EventItem>();

    public EventAdapter() {

    }
    public EventAdapter(ArrayList<EventItem> pagelist) {
        listViewItemList= pagelist;
    }

    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.item_mypage, parent, false);


        EventItem listViewItem = listViewItemList.get(position);


        return convertView;
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }

    public void addItem(String path, String name, String date) {
        EventItem item = new EventItem(path, name, date);
        listViewItemList.add(item);
    }
}
