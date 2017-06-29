package com.example.jungjune.mypt.Activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ScrollView;

import com.example.jungjune.mypt.Adapter.BestRecycleAdapter;
import com.example.jungjune.mypt.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends TitleBarActivity {
    @BindView(R.id.contentPanel)ScrollView sc;
    @BindView(R.id.recycleView)RecyclerView recyclerView;

    BestRecycleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        View v = LayoutInflater.from(this).inflate(R.layout.view_best, null);
        ButterKnife.bind(this,v);
        sc.addView(v);

        adapter=new BestRecycleAdapter(getApplicationContext(),null,R.layout.activity_main);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        adapter.addItem(R.drawable.btn_float_ok,"이정준","ㄴㄴ");
    }
}
