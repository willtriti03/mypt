package com.example.jungjune.mypt.Adapter;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jungjune.mypt.Activity.NoticeActivity;
import com.example.jungjune.mypt.Item.NoticeItem;
import com.example.jungjune.mypt.R;

import java.util.ArrayList;

/**
 * Created by triti on 2017-07-25.
 */

public class NoticeAdapter extends BaseAdapter {
    FragmentManager fm;
    FragmentTransaction fragmentTransaction;
    private ArrayList<NoticeItem> listViewItemList = new ArrayList<NoticeItem>();

    public NoticeAdapter() {

    }
    public NoticeAdapter(ArrayList<NoticeItem> pagelist) {
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
        convertView = inflater.inflate(R.layout.item_notice, parent, false);

        TextView noticeText =(TextView)convertView.findViewById(R.id.noticeName);
        TextView noticeDate =(TextView)convertView.findViewById(R.id.noticeDate);
        final LinearLayout tab =(LinearLayout)convertView.findViewById(R.id.tab);
        LinearLayout noticePanel =(LinearLayout)convertView.findViewById(R.id.noticePanel);
        final TextView content = (TextView)convertView.findViewById(R.id.context);
        Button close =(Button)convertView.findViewById(R.id.close);
        final NoticeItem listViewItem = listViewItemList.get(position);
    
        tab.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,0));
        noticeText.setText(listViewItem.getName());
        noticeDate.setText(listViewItem.getDate());
        noticePanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tab.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                content.setText(listViewItem.getText());
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tab.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,0));
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

    public void addItem(String name, String date, String text,String to) {
        NoticeItem item = new NoticeItem(name, date, text,to);
        listViewItemList.add(item);
    }
}
