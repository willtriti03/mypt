package com.example.jungjune.mypt.Fragment.SearchCunsumer;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jungjune.mypt.Fragment.CustomSearch.CustomOptionFragment;
import com.example.jungjune.mypt.Fragment.Utilty.FilterFragment;
import com.example.jungjune.mypt.Fragment.Utilty.ListFragment;
import com.example.jungjune.mypt.R;

/**
 * Created by triti on 2017-07-19.
 */

public class SearchCunsumerFragment extends Fragment {
    View v;
    Context context;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    SearchCunsumerListFragment searchCunsumerListFragment;
    FilterFragment filterFragment;
    SearchCunsumerOption searchCunsumerOption;

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

        searchCunsumerListFragment = new SearchCunsumerListFragment();
        filterFragment = new FilterFragment();
        searchCunsumerOption = new SearchCunsumerOption();

        filterFragment.setName("필터 열기", "높은 가격순", "10회");
        filterFragment.setFragment(fragmentManager, fragmentTransaction, searchCunsumerOption);
        searchCunsumerOption.setFragment(fragmentManager, fragmentTransaction, filterFragment);

        fragmentTransaction.replace(R.id.cunsumerList, searchCunsumerListFragment);
        fragmentTransaction.replace(R.id.option, filterFragment);
        fragmentTransaction.commit();

        return v;
    }


}
