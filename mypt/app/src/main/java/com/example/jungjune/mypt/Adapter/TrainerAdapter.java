package com.example.jungjune.mypt.Adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.jungjune.mypt.Activity.ProfilViewActivity;
import com.example.jungjune.mypt.Item.BestRecycleItem;
import com.example.jungjune.mypt.Item.TrainerItem;
import com.example.jungjune.mypt.R;

import java.util.List;

/**
 * Created by jungjune on 2017-06-30.
 */

public class TrainerAdapter  extends RecyclerView.Adapter<TrainerAdapter.ViewHolder> {
    Context context;
    List<TrainerItem> items;
    int item_layout;
    public TrainerAdapter(Context context, List<TrainerItem> items, int item_layout) {
        this.context = context;
        this.items = items;
        this.item_layout = item_layout;
    }

    @Override
    public TrainerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trainer, null);
        return new TrainerAdapter.ViewHolder(v);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(final TrainerAdapter.ViewHolder holder, int position) {
        final TrainerItem item = items.get(position);

        holder.image.setBackground(context.getDrawable(item.getDw()));
        holder.heart.setBackground(context.getDrawable(R.drawable.ic_trainer_like_normal));
        holder.name.setText(item.getName());
        holder.gym.setText(item.getLocation());
        holder.money.setText(item.getMoney()+"원");
        holder.like.setText(item.getLike()+"K");
        holder.star.setText(item.getStar()+"");
        if(item.getBest())
            holder.bestImage.setVisibility(View.VISIBLE);
        else
            holder.bestImage.setVisibility(View.INVISIBLE);

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, ProfilViewActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });
        holder.likeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!holder.onOff){
                    holder.likeBtn.setBackground(context.getDrawable(R.drawable.trainer_like_btn_red));
                    holder.heart.setBackground(context.getDrawable(R.drawable.ic_trainer_like_on));
                    holder.like.setTextColor(Color.parseColor("#ffffff"));
                    holder.onOff=true;
                }
                else{
                    holder.likeBtn.setBackground(context.getDrawable(R.drawable.round_rantangle_white));
                    holder.heart.setBackground(context.getDrawable(R.drawable.ic_trainer_like_normal));
                    holder.like.setTextColor(Color.parseColor("#EF5350"));
                    holder.onOff=false;
                }

            }
        });
        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        android.view.ViewGroup.LayoutParams layoutParams = holder.image.getLayoutParams();
        holder.image.setLayoutParams(layoutParams);
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
        boolean onOff=false;

        public ViewHolder(View itemView) {
            super(itemView);
            image=(ImageView) itemView.findViewById(R.id.imageView);
            heart=(ImageView) itemView.findViewById(R.id.trainerLikeHeart);
            bestImage=(Button) itemView.findViewById(R.id.bestTag);
            name =(TextView) itemView.findViewById(R.id.profil_name);
            gym=(TextView) itemView.findViewById(R.id.gym_location);
            money=(TextView) itemView.findViewById(R.id.money);
            like =(TextView) itemView.findViewById(R.id.trainerLike);
            star =(TextView) itemView.findViewById(R.id.trainerStar);
            likeBtn = (ImageButton) itemView.findViewById(R.id.like);
            cardview = (CardView) itemView.findViewById(R.id.trainer);


        }
    }
}

