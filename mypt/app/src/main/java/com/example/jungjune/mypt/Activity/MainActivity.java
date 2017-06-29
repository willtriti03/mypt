package com.example.jungjune.mypt.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

import com.example.jungjune.mypt.Adapter.BestRecycleAdapter;
import com.example.jungjune.mypt.Item.BestRecycleItem;
import com.example.jungjune.mypt.R;
import com.example.jungjune.mypt.Util.BestTab;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends TitleBarActivity {
    @BindView(R.id.contentPanel)ScrollView sc;
    @BindView(R.id.search_bar)Button search;
    RecyclerView recyclerView;
    BestRecycleAdapter adapter;
    LinearLayoutManager layoutManager;
    View v;
    int status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

    }


}
