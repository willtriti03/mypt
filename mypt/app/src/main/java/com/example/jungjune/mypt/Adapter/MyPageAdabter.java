package com.example.jungjune.mypt.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jungjune.mypt.Activity.CenterActivity;
import com.example.jungjune.mypt.Activity.EventActivity;
import com.example.jungjune.mypt.Activity.ILikeItActivity;
import com.example.jungjune.mypt.Activity.NoticeActivity;
import com.example.jungjune.mypt.Activity.ResultActivity;
import com.example.jungjune.mypt.Activity.ReviewListActivity;
import com.example.jungjune.mypt.Activity.SpecActivity;
import com.example.jungjune.mypt.Activity.TrainerPTResultActivity;
import com.example.jungjune.mypt.Activity.WrittenReviewActivity;
import com.example.jungjune.mypt.Item.MyPageItem;
import com.example.jungjune.mypt.R;

import java.util.ArrayList;

/**
 * Created by jungjune on 2017-07-14.
 */

public class MyPageAdabter extends BaseAdapter {
    private ArrayList<MyPageItem> listViewItemList = new ArrayList<MyPageItem>();

    public MyPageAdabter() {

    }
    public MyPageAdabter(ArrayList<MyPageItem> pagelist) {
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
        convertView = inflater.inflate(R.layout.item_mypage, parent, false);


        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.icons);
        TextView titleTextView = (TextView) convertView.findViewById(R.id.content);

        final MyPageItem listViewItem = listViewItemList.get(position);

        iconImageView.setBackground(listViewItem.getImg());
        titleTextView.setText(listViewItem.getContent());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (listViewItem.getTo()){
                    case "event":
                        context.startActivity(new Intent(context, EventActivity.class));
                        break;
                    case "jjim":
                        context.startActivity(new Intent(context, ILikeItActivity.class));
                        break;
                    case "notice":
                        context.startActivity(new Intent(context, NoticeActivity.class));
                        break;
                    case "writtenReview":
                        context.startActivity(new Intent(context, WrittenReviewActivity.class));
                        break;
                    case "spec":
                        context.startActivity(new Intent(context, SpecActivity.class).putExtra("people", "24")
                                .putExtra("career","4").putExtra("lisence","dasdasdd\ndsadsaddsa")
                                .putExtra("prize","dsdasdsadsadasdsadsa\ndsadasdsadas\nsadasdsa"));
                        break;
                    case "callcenter":
                        context.startActivity(new Intent(context, CenterActivity.class));
                        break;
                    case "result":
                        context.startActivity(new Intent(context, ResultActivity.class));
                        break;
                    case "resultT":
                        context.startActivity(new Intent(context, TrainerPTResultActivity.class));
                        break;
                    case "review":
                        context.startActivity(new Intent(context, ReviewListActivity.class));
                        break;
                }
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

    public void addItem(Drawable icon, String content, String to) {
        MyPageItem item = new MyPageItem(icon,content,to);
        listViewItemList.add(item);
    }
}

