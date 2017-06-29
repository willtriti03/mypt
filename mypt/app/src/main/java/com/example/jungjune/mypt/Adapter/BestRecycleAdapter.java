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
import android.widget.Toast;

import com.example.jungjune.mypt.Item.BestRecycleItem;
import com.example.jungjune.mypt.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jungjune on 2017-06-29.
 */

public class BestRecycleAdapter extends RecyclerView.Adapter<BestRecycleAdapter.ViewHolder> {
    Context context;
    List<BestRecycleItem> items;
    int item_layout;

    public BestRecycleAdapter(Context context, List<BestRecycleItem> items, int item_layout) {
        this.context = context;
        this.items = items;
        this.item_layout = item_layout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item, null);
        return new ViewHolder(v);
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
    }
    public void addItem(Drawable dw, String name, String info){
        items.add(new BestRecycleItem(dw,name,info));
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
            cardview =(CardView)itemView.findViewById(R.id.cardview);
            image= (ImageView)itemView.findViewById(R.id.image);
            title = (TextView)itemView.findViewById(R.id.name);


        }
    }
}
