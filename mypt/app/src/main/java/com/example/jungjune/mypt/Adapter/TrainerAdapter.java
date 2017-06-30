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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jungjune.mypt.Item.BestRecycleItem;
import com.example.jungjune.mypt.R;

import java.util.List;

/**
 * Created by jungjune on 2017-06-30.
 */

public class TrainerAdapter  extends RecyclerView.Adapter<TrainerAdapter.ViewHolder> {
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

    public TrainerAdapter(Context context, List<BestRecycleItem> items, int item_layout,int width) {
        this.context = context;
        this.items = items;
        this.item_layout = item_layout;
        setWidth(width);
    }

    @Override
    public TrainerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trainer, null);
        return new TrainerAdapter.ViewHolder(v);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(TrainerAdapter.ViewHolder holder, int position) {
        final BestRecycleItem item = items.get(position);


        android.view.ViewGroup.LayoutParams layoutParams = holder.image.getLayoutParams();
        layoutParams.width=getWidth();
        holder.image.setLayoutParams(layoutParams);
    }
    public void addItem(Drawable dw, String name, String info){
        items.add(new BestRecycleItem(dw,name,info));
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image, heart;
        Button  bestImage;
        TextView name, gym, money,like, star;
        ImageButton likeBtn;
        CardView cardview;
        public ViewHolder(View itemView) {
            super(itemView);
            image=(ImageView) itemView.findViewById(R.id.imageView);
            heart=(ImageView) itemView.findViewById(R.id.trainerLikeHeart);
            bestImage=(Button) itemView.findViewById(R.id.bestTag);
            name =(TextView) itemView.findViewById(R.id.name);
            gym=(TextView) itemView.findViewById(R.id.gym_location);
            money=(TextView) itemView.findViewById(R.id.money);
            like =(TextView) itemView.findViewById(R.id.trainerLike);
            star =(TextView) itemView.findViewById(R.id.trainerStar);
            likeBtn = (ImageButton) itemView.findViewById(R.id.like);
            cardview = (CardView) itemView.findViewById(R.id.trainer);


        }
    }
}

