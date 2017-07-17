package com.example.jungjune.mypt.Adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jungjune.mypt.Item.ImageSlideItem;
import com.example.jungjune.mypt.R;

import java.util.ArrayList;

/**
 * Created by jungjune on 2017-07-17.
 */

public class ImageSlideAdabter extends RecyclerView.Adapter<ImageSlideAdabter.ViewHolder>{
    Context context;
    ArrayList<ImageSlideItem> listViewItemList;
    View v1;

    int item_layout;
    int width;

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
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
        Glide.with(v1).load(item.getPath()).into(holder.image);

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
        item.setPath(path);
        listViewItemList.add(item);
    }
}
