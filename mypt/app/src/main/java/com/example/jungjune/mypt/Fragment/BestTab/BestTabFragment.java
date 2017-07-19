package com.example.jungjune.mypt.Fragment.BestTab;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.jungjune.mypt.Adapter.BestRecycleAdapter;
import com.example.jungjune.mypt.Fragment.Utilty.ListFragment;
import com.example.jungjune.mypt.Item.BestRecycleItem;
import com.example.jungjune.mypt.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by triti on 2017-06-29.
 */

public class BestTabFragment extends Fragment {
    int max;
    int status;
    int nowDot=0;
    int time=0;

    View v;
    Button dots;
    Timer tm;
    TimerTask tk;
    Context context;
    ArrayList<Button> ab = new ArrayList<Button>();
    RecyclerView recyclerView;
    BestRecycleAdapter adapter;
    LinearLayoutManager layoutManager;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context= getActivity();
        v = inflater.inflate(R.layout.fragment_best, container, false);
        layoutManager = new LinearLayoutManager(context.getApplicationContext());
        setRecyclerView();
        tk = new TimerTask() {
            @Override
            public void run() {
                time=nowDot+1;
                recyclerView.smoothScrollToPosition(time%max);
            }
        };
        tm = new Timer();
        tm.schedule(tk,4000,4000);

        ListFragment fragment2 = new ListFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.trainerContent, fragment2);
        fragmentTransaction.commit();
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        ab.clear();
        createDots();
    }

    @Override
    public void onPause() {
        super.onPause();
        tm.cancel();
    }

    @Override
    public void onStop() {
        super.onStop();
        tm.cancel();
    }

    public void setMax(final int max) {
        this.max = max;

    }
    public void changTo(int change){
        ab.get(nowDot).setBackground(context.getDrawable(R.drawable.dot_gray));
        ab.get(change).setBackground(context.getDrawable(R.drawable.dot_blue));
        nowDot=change;


    }
    public void createDots(){
        LinearLayout dotLayout=(LinearLayout)v.findViewById(R.id.dotLayout);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.width = dpToPx(10);
        params.height = dpToPx(10);
        params.leftMargin =dpToPx(3);
        params.rightMargin =dpToPx(3);
        for(int i=0; i<max; ++i){
            dots= new Button(context);
            dots.setLayoutParams(params);
            dots.setBackground(context.getDrawable(R.drawable.dot_gray));
            dots.setStateListAnimator(null);
            ab.add(dots);
            dotLayout.addView(dots);
        }
        ab.get(nowDot).setBackground(context.getDrawable(R.drawable.dot_blue));
    }
    private void setRecyclerView(){
        recyclerView= (RecyclerView) v.findViewById(R.id.recycleView);

        Display display = getActivity().getWindowManager().getDefaultDisplay();
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        snapHelper.onFling(1,0);

        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        List<BestRecycleItem> items=new ArrayList<>();
        BestRecycleItem[] item=new BestRecycleItem[5];
        item[0]=new BestRecycleItem(R.drawable.dasd,"#1","asddas");
        item[1]=new BestRecycleItem(R.drawable.dasd,"#2","asddas");
        item[2]=new BestRecycleItem(R.drawable.dasd,"#3","asddas");
        item[3]=new BestRecycleItem(R.drawable.dasd,"#4","asddas");
        item[4]=new BestRecycleItem(R.drawable.dasd,"#5","asddas");

        for(int i=0;i<5;i++) items.add(item[i]);
        adapter = new BestRecycleAdapter(context.getApplicationContext(),items,R.layout.activity_main, display.getWidth()-dpToPx(57));
        recyclerView.setAdapter(adapter);
        setMax(items.size());

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState==RecyclerView.SCROLL_STATE_IDLE&&status==RecyclerView.SCROLL_STATE_SETTLING){
                    changTo(layoutManager.findFirstVisibleItemPosition());
                }
                status=newState;
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }
    public void setNowDot(){
        nowDot=layoutManager.findFirstVisibleItemPosition();
        ab.get(nowDot).setBackground(context.getDrawable(R.drawable.dot_blue));
    }
    public int dpToPx(int dp) {
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }
}
