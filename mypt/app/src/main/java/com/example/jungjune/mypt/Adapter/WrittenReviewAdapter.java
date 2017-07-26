package com.example.jungjune.mypt.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jungjune.mypt.Item.EventItem;
import com.example.jungjune.mypt.Item.WrittenReviewItem;
import com.example.jungjune.mypt.R;

import java.util.ArrayList;

/**
 * Created by jungjune on 2017-07-26.
 */

public class WrittenReviewAdapter extends BaseAdapter {
    private ArrayList<WrittenReviewItem> listViewItemList = new ArrayList<WrittenReviewItem>();

    public WrittenReviewAdapter() {

    }
    public WrittenReviewAdapter(ArrayList<WrittenReviewItem> pagelist) {
        listViewItemList= pagelist;
    }

    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.item_written_reiview, parent, false);
        ImageView writtenProfil =(ImageView)convertView.findViewById(R.id.written_profil_image);
        TextView writtenName =(TextView)convertView.findViewById(R.id.written_name);
        TextView writtenText =(TextView)convertView.findViewById(R.id.written_introduce);
        TextView writtenTimeAgo =(TextView)convertView.findViewById(R.id.written_timeAgo);
        Button writtenGotoReview= (Button)convertView.findViewById(R.id.written_goToReview);
        Button wrttienDelete = (Button)convertView.findViewById(R.id.written_delete);
        WrittenReviewItem listViewItem = listViewItemList.get(position);

       // Glide.with(context).load(listViewItem.getImage()).into(writtenProfil);
        writtenProfil.setBackground(context.getDrawable(R.drawable.dadasdas));
        writtenName.setText(listViewItem.getName());
        writtenText.setText(listViewItem.getIntroduce());
        writtenTimeAgo.setText(listViewItem.getTime());

        wrttienDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listViewItemList.remove(position);
                notifyDataSetChanged();
            }
        });
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

    public void addItem(String image,String name, String introduce, String time,String to) {
        WrittenReviewItem item = new WrittenReviewItem(image,name, introduce, time,to);
        listViewItemList.add(item);
    }
}

