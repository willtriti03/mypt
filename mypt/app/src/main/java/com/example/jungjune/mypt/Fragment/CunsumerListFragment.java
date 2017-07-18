package com.example.jungjune.mypt.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jungjune.mypt.Adapter.CunsumerAdapter;
import com.example.jungjune.mypt.Adapter.TrainerAdapter;
import com.example.jungjune.mypt.Item.TrainerItem;
import com.example.jungjune.mypt.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by triti on 2017-07-18.
 */

public class CunsumerListFragment extends Fragment {
    View v;
    Context context;
    RecyclerView recyclerView;
    GridLayoutManager layoutManager;
    CunsumerAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        context=getActivity();
        v = inflater.inflate(R.layout.fragment_cunsumer_list, container, false);
        setList();
        return v;
    }
    public  void  setList(){
        recyclerView= (RecyclerView) v.findViewById(R.id.cunsumerList);

        Display display = getActivity().getWindowManager().getDefaultDisplay();
        layoutManager = new GridLayoutManager(context.getApplicationContext(),2){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new CunsumerAdapter();
        recyclerView.setAdapter(adapter);
        adapter.addItem("170cm","76kg","20000원","20회","지구 어딘가 ~~~");
        adapter.addItem("170cm","76kg","20000원","20회","지구 어딘가 ~~~");
        adapter.addItem("170cm","76kg","20000원","20회","지구 어딘가 ~~~");
        adapter.addItem("170cm","76kg","20000원","20회","지구 어딘가 ~~~");
        adapter.addItem("170cm","76kg","20000원","20회","지구 어딘가 ~~~");
        adapter.addItem("170cm","76kg","20000원","20회","지구 어딘가 ~~~");
        adapter.addItem("170cm","76kg","20000원","20회","지구 어딘가 ~~~");
        adapter.addItem("170cm","76kg","20000원","20회","지구 어딘가 ~~~");
        adapter.addItem("170cm","76kg","20000원","20회","지구 어딘가 ~~~");
        adapter.addItem("170cm","76kg","20000원","20회","지구 어딘가 ~~~");
        adapter.addItem("170cm","76kg","20000원","20회","지구 어딘가 ~~~");

        adapter.notifyDataSetChanged();
    }
}
