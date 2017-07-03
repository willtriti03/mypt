package com.example.jungjune.mypt.Fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.jungjune.mypt.Adapter.BestRecycleAdapter;
import com.example.jungjune.mypt.Adapter.TrainerAdapter;
import com.example.jungjune.mypt.Item.BestRecycleItem;
import com.example.jungjune.mypt.Item.TrainerItem;
import com.example.jungjune.mypt.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jungjune on 2017-06-30.
 */

public class ListFragment extends Fragment {
    View v;
    Context context;
    RecyclerView recyclerView;
    GridLayoutManager layoutManager;
    TrainerAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        context=getActivity();
        v = inflater.inflate(R.layout.fragment_trainerlist, container, false);
        setList();
        return v;
    }
    public  void  setList(){
        recyclerView= (RecyclerView) v.findViewById(R.id.trainerList);

        Display display = getActivity().getWindowManager().getDefaultDisplay();
        layoutManager = new GridLayoutManager(context.getApplicationContext(),2);


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        List<TrainerItem> items=new ArrayList<>();
        TrainerItem[] item=new TrainerItem[6];
        item[0]=new TrainerItem(context.getDrawable(R.drawable.dadasdas),"#1","asddas",10000,500,5,true);
        item[1]=new TrainerItem(context.getDrawable(R.drawable.dadasdas),"#2","asddas",10000,500,5,true);
        item[2]=new TrainerItem(context.getDrawable(R.drawable.dadasdas),"#3","asddas",10000,500,5,true);
        item[3]=new TrainerItem(context.getDrawable(R.drawable.dadasdas),"#4","asddas",10000,500,5,true);
        item[4]=new TrainerItem(context.getDrawable(R.drawable.dadasdas),"#5","asddas",10000,500,5,true);
        item[5]=new TrainerItem(context.getDrawable(R.drawable.dadasdas),"#6","asddas",10000,500,5,true);

        for(int i=0;i<6;i++) items.add(item[i]);
        adapter = new TrainerAdapter(context.getApplicationContext(),items,R.layout.fragment_best);
        recyclerView.setAdapter(adapter);

    }
}
