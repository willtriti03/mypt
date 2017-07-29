package com.example.jungjune.mypt.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jungjune.mypt.Activity.EventDetailActivity;
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
        convertView = inflater.inflate(R.layout.item_event, parent, false);

        ImageView imageView = (ImageView)convertView.findViewById(R.id.eventImage);
        TextView eventText =(TextView)convertView.findViewById(R.id.eventName);
        TextView eventDate =(TextView)convertView.findViewById(R.id.eventDate);

        EventItem listViewItem = listViewItemList.get(position);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, EventDetailActivity.class));
            }
        });
       // imageView.setBackground(context.getDrawable(R.drawable.aaasss));
        Glide.with(context).load(R.drawable.aaasss).centerCrop().into(imageView);
        eventText.setText(listViewItem.getName());
        eventDate.setText(listViewItem.getDate());

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
