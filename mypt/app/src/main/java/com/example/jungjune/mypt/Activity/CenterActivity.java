package com.example.jungjune.mypt.Activity;

import android.content.Intent;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.example.jungjune.mypt.Adapter.CenterAdapter;
import com.example.jungjune.mypt.R;
import com.example.jungjune.mypt.Util.TextTitleActivity;
import com.example.jungjune.mypt.Util.TitleBarActivity;

public class CenterActivity extends TextTitleActivity {
    TabLayout tablayout;
    ViewPager pager;
    FloatingActionButton fab;
    CenterAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setTitle("고객센터");
        setContentView(R.layout.activity_center);
        tablayout = (TabLayout) findViewById(R.id.PagerTab);
        pager = (ViewPager) findViewById(R.id.pager);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        tablayout.addTab(tablayout.newTab().setText("문의하기"));
        tablayout.addTab(tablayout.newTab().setText("내 문의내역"));
        adapter = new CenterAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                pager.setCurrentItem(tab.getPosition());
                switch (tablayout.getSelectedTabPosition()) {
                    case 0:
                        fab.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        fab.setVisibility(View.INVISIBLE);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

                switch (tablayout.getSelectedTabPosition()) {
                    case 0:
                        break;
                    case 1:
                        break;
                }

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
