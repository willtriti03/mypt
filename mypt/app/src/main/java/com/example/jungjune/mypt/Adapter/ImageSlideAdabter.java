package com.example.jungjune.mypt.Adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.jungjune.mypt.Item.ImageSlideItem;
import com.example.jungjune.mypt.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jungjune on 2017-07-17.
 */

public class ImageSlideAdabter extends RecyclerView.Adapter<ImageSlideAdabter.ViewHolder>{
    Context context;
    ArrayList<ImageSlideItem> listViewItemList= new ArrayList<ImageSlideItem>();
    View v1;

    int item_layout;
    int width;

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }
    public ImageSlideAdabter(Context ct){
        context=ct;
    }
    public ImageSlideAdabter(Context ct, ArrayList<ImageSlideItem> arr){
        context=ct;
        listViewItemList=arr;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        v1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_imageslide, null);
        return new ViewHolder(v1);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(ImageSlideAdabter.ViewHolder holder, int position) {
        final ImageSlideItem item = listViewItemList.get(position);
        Log.e("Adding","bing");
        Glide.with(context).load(item.getPath()).into(holder.image);
        android.view.ViewGroup.LayoutParams layoutParams = holder.image.getLayoutParams();
        layoutParams.width = getWidth();
        holder.image.setLayoutParams(layoutParams);
    }

    @Override
    public int getItemCount() {
        return this.listViewItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView)itemView.findViewById(R.id.imageView);
        }
    }
    public void addItem(String path) {
        ImageSlideItem item = new ImageSlideItem();
        Log.e("추가됨!","++++"+path+"  "+getItemCount());
        item.setPath(path);
        listViewItemList.add(item);
    }
}