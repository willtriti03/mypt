package com.example.jungjune.mypt.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jungjune.mypt.Item.EventItem;
import com.example.jungjune.mypt.Item.NoticeItem;
import com.example.jungjune.mypt.R;

import java.util.ArrayList;

/**
 * Created by triti on 2017-07-25.
 */

public class NoticeAdapter extends BaseAdapter {
    private ArrayList<NoticeItem> listViewItemList = new ArrayList<NoticeItem>();

    public NoticeAdapter() {

    }
    public NoticeAdapter(ArrayList<NoticeItem> pagelist) {
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
        convertView = inflater.inflate(R.layout.item_notice, parent, false);

        TextView noticeText =(TextView)convertView.findViewById(R.id.noticeName);
        TextView noticeDate =(TextView)convertView.findViewById(R.id.noticeDate);

        NoticeItem listViewItem = listViewItemList.get(position);

        noticeText.setText(listViewItem.getName());
        noticeDate.setText(listViewItem.getDate());

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

    public void addItem(String name, String date, String to) {
        NoticeItem item = new NoticeItem(name, date, to);
        listViewItemList.add(item);
    }
}
