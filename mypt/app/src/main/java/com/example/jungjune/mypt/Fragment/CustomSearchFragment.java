package com.example.jungjune.mypt.Fragment;

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
import com.example.jungjune.mypt.Item.BestRecycleItem;
import com.example.jungjune.mypt.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by jungjune on 2017-07-18.
 */

public class CustomSearchFragment extends Fragment {
    View v;
    Context context;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    ListFragment listFragment;
    FilterFragment filterFragment;
    CustomOptionFragment customOptionFragment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();
        v = inflater.inflate(R.layout.fragment_cunsumer, container, false);

        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        listFragment = new ListFragment();
        filterFragment = new FilterFragment();
        customOptionFragment = new CustomOptionFragment();

        filterFragment.setName("필터 열기", "높은 가격순", "높은 찜순");
        filterFragment.setFragment(fragmentManager,fragmentTransaction,customOptionFragment);

        fragmentTransaction.replace(R.id.cunsumerList, listFragment);
        fragmentTransaction.replace(R.id.option, filterFragment);
        fragmentTransaction.commit();

        return v;
    }

    public void changeToFilter(){
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.option, filterFragment);
        fragmentTransaction.commit();
    }

}