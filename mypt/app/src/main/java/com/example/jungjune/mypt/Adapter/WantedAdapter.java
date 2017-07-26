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
import com.example.jungjune.mypt.Activity.EventActivity;
import com.example.jungjune.mypt.Activity.ILikeItActivity;
import com.example.jungjune.mypt.Item.EventItem;
import com.example.jungjune.mypt.Item.MyPageItem;
import com.example.jungjune.mypt.Item.WantedItem;
import com.example.jungjune.mypt.R;

import java.util.ArrayList;

/**
 * Created by jungjune on 2017-07-23.
 */

public class WantedAdapter extends BaseAdapter {
    private ArrayList<WantedItem> listViewItemList = new ArrayList<WantedItem>();

    public WantedAdapter() {

    }
    public WantedAdapter(ArrayList<WantedItem> pagelist) {
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
        ImageView[] img=  new ImageView[5];
        ArrayList<String> arrayList = new ArrayList<String>();

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_wanted_trainer, parent, false);
        }

        ImageView profil = (ImageView)convertView.findViewById(R.id.want_profil_image);
        img[0] = (ImageView)convertView.findViewById(R.id.img1);
        img[1]= (ImageView)convertView.findViewById(R.id.img2);
        img[2]= (ImageView)convertView.findViewById(R.id.img3);
        img[3] = (ImageView)convertView.findViewById(R.id.img4);
        img[4] = (ImageView)convertView.findViewById(R.id.img5);
        TextView name = (TextView)convertView.findViewById(R.id.want_name);
        TextView introduce = (TextView)convertView.findViewById(R.id.want_introduce);
        TextView timeAgo    =(TextView)convertView.findViewById(R.id.want_timeAgo);
        WantedItem listViewItem = listViewItemList.get(position);
        arrayList = listViewItem.getImageList();
        /*
        Glide.with(context).load(arrayList.get(0)).centerCrop().into(profil);
        for(int i = 0; i< arrayList.size(); ++i ){
            Glide.with(context).load(arrayList.get(i+1)).centerCrop().into(img[i]);
        }
        */
        Glide.with(context).load(R.drawable.dadasdas).centerCrop().into(profil);
        for(int i = 0; i< 5; ++i ){
            Glide.with(context).load(R.drawable.dasd).centerCrop().into(img[i]);
        }

        name.setText(listViewItem.getName());
        introduce.setText(listViewItem.getIntroduce());
        timeAgo.setText(listViewItem.getTime()+"전");

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

    public void addItem(ArrayList<String> arr, String content, String to,String time) {
        WantedItem item = new WantedItem(arr,content,to,time);
        listViewItemList.add(item);
    }
}

