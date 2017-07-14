package com.example.jungjune.mypt.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jungjune.mypt.Item.MyPageItem;
import com.example.jungjune.mypt.R;

import java.util.ArrayList;

/**
 * Created by jungjune on 2017-07-14.
 */

public class MyPageAdabter extends BaseAdapter {
    private ArrayList<MyPageItem> listViewItemList = new ArrayList<MyPageItem>();

    public MyPageAdabter() {

    }
    public MyPageAdabter(ArrayList<MyPageItem> pagelist) {
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


        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.icons);
        TextView titleTextView = (TextView) convertView.findViewById(R.id.content);

        MyPageItem listViewItem = listViewItemList.get(position);

        iconImageView.setBackground(listViewItem.getImg());
        titleTextView.setText(listViewItem.getContent());

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

    public void addItem(Drawable icon, String content, String to) {
        MyPageItem item = new MyPageItem(icon,content,to);
        listViewItemList.add(item);
    }
}

