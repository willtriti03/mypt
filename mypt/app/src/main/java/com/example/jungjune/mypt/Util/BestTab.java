package com.example.jungjune.mypt.Util;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.jungjune.mypt.Adapter.BestRecycleAdapter;
import com.example.jungjune.mypt.Item.BestRecycleItem;
import com.example.jungjune.mypt.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by triti on 2017-06-29.
 */

public class BestTab extends View{
    int max;
    Button[] dots;
    Context context;
    View v;
    LinearLayout.LayoutParams pm;

    public BestTab(Context context) {
        super(context);
    }

    public BestTab(Context context, ScrollView sc){
        super(context);
        this.context=context;
        v = LayoutInflater.from(context).inflate(R.layout.view_best, null);
        sc.addView(v);
    }

    public void setPm(LinearLayout.LayoutParams pm) {
        this.pm = pm;
    }

    public LinearLayout.LayoutParams getPm() {
        return pm;
    }

    public void setMax(int max) {
        this.max = max;
        createDots();
    }
    public int getMax() {
        return max;
    }

    public void changTo(int change){

    }
    public void createDots(){
        getMax();
        for(int i=0; i<max; ++i){
            dots[i]= new Button(context);
            dots[i].setLayoutParams(pm);

        }
    }
    private void setRecyclerView(){
        recyclerView= (RecyclerView) v.findViewById(R.id.recycleView);

        Display display = getWindowManager().getDefaultDisplay();
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        snapHelper.onFling(80,0);

        layoutManager=new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        List<BestRecycleItem> items=new ArrayList<>();
        BestRecycleItem[] item=new BestRecycleItem[5];
        item[0]=new BestRecycleItem(getDrawable(R.drawable.dasd),"#1","asddas");
        item[1]=new BestRecycleItem(getDrawable(R.drawable.dasd),"#2","asddas");
        item[2]=new BestRecycleItem(getDrawable(R.drawable.dasd),"#3","asddas");
        item[3]=new BestRecycleItem(getDrawable(R.drawable.dasd),"#4","asddas");
        item[4]=new BestRecycleItem(getDrawable(R.drawable.dasd),"#5","asddas");

        for(int i=0;i<5;i++) items.add(item[i]);

        adapter = new BestRecycleAdapter(getApplicationContext(),items,R.layout.activity_main, display.getWidth()-dpToPx(57));
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState==RecyclerView.SCROLL_STATE_IDLE&&status==RecyclerView.SCROLL_STATE_SETTLING){
                }
                status=newState;
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }
    public int dpToPx(int dp) {
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }
}
