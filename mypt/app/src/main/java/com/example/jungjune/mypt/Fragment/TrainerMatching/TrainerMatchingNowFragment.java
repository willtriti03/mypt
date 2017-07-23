package com.example.jungjune.mypt.Fragment.TrainerMatching;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.jungjune.mypt.Adapter.WantedAdapter;
import com.example.jungjune.mypt.R;

import java.util.ArrayList;

/**
 * Created by jungjune on 2017-07-23.
 */

public class TrainerMatchingNowFragment extends Fragment {
    Context context;
    View view;
    ListView listView;
    WantedAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context= getActivity();
        view  = inflater.inflate(R.layout.fragment_matching_now,container,false);
        listView = (ListView)view.findViewById(R.id.wantedList);
        adapter = new WantedAdapter();
        listView.setAdapter(adapter);
        adapter.addItem(new ArrayList<String>(),"이이름","길게 치기 위해 막 치고 있는 텍스트입니다 쌰쌰ㅑ쌰쌰썄ㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆ");
        adapter.addItem(new ArrayList<String>(),"이이름","길게 치기 위해 막 치고 있는 텍스트입니다 쌰쌰ㅑ쌰쌰썄ㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆ");
        adapter.addItem(new ArrayList<String>(),"이이름","길게 치기 위해 막 치고 있는 텍스트입니다 쌰쌰ㅑ쌰쌰썄ㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆㅆ");
        //listView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, (adapter.getCount()+1)*dpToPx(104)));
        adapter.notifyDataSetChanged();

        return view;
    }
    public int dpToPx(int dp) {
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

}
