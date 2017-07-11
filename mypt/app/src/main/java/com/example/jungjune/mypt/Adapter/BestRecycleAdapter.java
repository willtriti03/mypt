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

import com.example.jungjune.mypt.Item.BestRecycleItem;
import com.example.jungjune.mypt.R;

import java.util.List;

/**
 * Created by jungjune on 2017-06-29.
 */

public class BestRecycleAdapter extends RecyclerView.Adapter<BestRecycleAdapter.ViewHolder> {
    Context context;
    List<BestRecycleItem> items;
    int item_layout;
    int width;

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public BestRecycleAdapter(Context context, List<BestRecycleItem> items, int item_layout, int width) {
        this.context = context;
        this.items = items;
        this.item_layout = item_layout;
        setWidth(width);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview, null);

        return new ViewHolder(v1);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final BestRecycleItem item = items.get(position);
        Drawable drawable = item.getImage();
        holder.image.setBackground(drawable);
        holder.title.setText(item.getName());
        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        android.view.ViewGroup.LayoutParams layoutParams = holder.image.getLayoutParams();
        layoutParams.width = getWidth();
        holder.image.setLayoutParams(layoutParams);
    }

    public void addItem(Drawable dw, String name, String info) {
        items.add(new BestRecycleItem(dw, name, info));
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        CardView cardview;

        public ViewHolder(View itemView) {
            super(itemView);
            cardview = (CardView) itemView.findViewById(R.id.cardview);
            image = (ImageView) itemView.findViewById(R.id.image);
            title = (TextView) itemView.findViewById(R.id.name);


        }
    }
}
