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
import android.widget.Button;

import com.example.jungjune.mypt.Fragment.Utilty.FilterFragment;
import com.example.jungjune.mypt.R;

/**
 * Created by triti on 2017-07-18.
 */

public class CustomOptionFragment extends Fragment {
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    FilterFragment filterFragment;
    Context context;
    View v;
    Button searchBtn;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();
        v = inflater.inflate(R.layout.fragment_custom_option, container, false);
        searchBtn=(Button)v.findViewById(R.id.commit);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeToFilter();
            }
        });
        return v;
    }
    public void setFragment(FragmentManager fragmentManager, FragmentTransaction fragmentTransaction,FilterFragment filterFragment){
        this.fragmentManager = fragmentManager;
        this.fragmentTransaction = fragmentTransaction;
        this.filterFragment = filterFragment;
    }

    public void changeToFilter(){
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.option, filterFragment);
        fragmentTransaction.commit();
    }
}
