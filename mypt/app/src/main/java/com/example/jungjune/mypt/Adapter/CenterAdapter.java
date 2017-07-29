package com.example.jungjune.mypt.Adapter;

import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.jungjune.mypt.Fragment.Center.FragmentAsk;
import com.example.jungjune.mypt.Fragment.Center.FragmentAskList;

/**
 * Created by choi on 2017. 7. 28..
 */

public class CenterAdapter extends FragmentStatePagerAdapter {
    int tabCount;

    public CenterAdapter(android.support.v4.app.FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }
    public CenterAdapter(android.support.v4.app.FragmentManager fm) {
        super(fm);
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FragmentAsk();
            case 1:
                return new FragmentAskList();
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return 2;
    }
}
