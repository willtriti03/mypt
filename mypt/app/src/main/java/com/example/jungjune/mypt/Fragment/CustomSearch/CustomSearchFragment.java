package com.example.jungjune.mypt.Fragment.CustomSearch;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jungjune.mypt.Fragment.Utilty.FilterFragment;
import com.example.jungjune.mypt.Fragment.Utilty.ListFragment;
import com.example.jungjune.mypt.R;

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
        customOptionFragment.setFragment(fragmentManager,fragmentTransaction,filterFragment);

        fragmentTransaction.replace(R.id.cunsumerList, listFragment);
        fragmentTransaction.replace(R.id.option, filterFragment);
        fragmentTransaction.commit();

        return v;
    }


}