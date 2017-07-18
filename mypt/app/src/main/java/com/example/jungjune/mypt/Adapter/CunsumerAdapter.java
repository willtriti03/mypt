package com.example.jungjune.mypt.Adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jungjune.mypt.Item.CunsumerItem;
import com.example.jungjune.mypt.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by triti on 2017-07-18.
 */

public class CunsumerAdapter extends RecyclerView.Adapter<CunsumerAdapter.ViewHolder> {
    Context context;
    ArrayList<CunsumerItem> items= new ArrayList<CunsumerItem>();
    int item_layout;


    @Override
    public CunsumerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cunsumer_inform, null);
        return new CunsumerAdapter.ViewHolder(v);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(final CunsumerAdapter.ViewHolder holder, int position) {
        final CunsumerItem item = items.get(position);
        holder.height.setText(item.getHeight());
        holder.weight.setText(item.getWeight());
        holder.oneTime.setText(item.getOneTime());
        holder.time.setText(item.getTime());
        holder.location.setText(item.getLocation());

        android.view.ViewGroup.LayoutParams layoutParams = holder.cardView.getLayoutParams();
        holder.cardView.setLayoutParams(layoutParams);
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView height,weight,oneTime,time,location;
        public ViewHolder(View itemView) {
            super(itemView);
            cardView=(CardView)itemView.findViewById(R.id.cardview);
            height=(TextView)itemView.findViewById(R.id.man_height);
            weight=(TextView)itemView.findViewById(R.id.man_weight);
            oneTime=(TextView)itemView.findViewById(R.id.man_oneTime);
            time = (TextView)itemView.findViewById(R.id.man_time);
            location=(TextView)itemView.findViewById(R.id.man_address);
        }
    }
    public void addItem(String height,String weight,String oneTime,String time,String location){
        CunsumerItem item = new CunsumerItem(height,weight,oneTime,time,location);
        items.add(item);
    }
}

