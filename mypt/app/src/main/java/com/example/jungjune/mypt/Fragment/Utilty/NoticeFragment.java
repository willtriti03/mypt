package com.example.jungjune.mypt.Fragment.Utilty;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.jungjune.mypt.Adapter.TrainerAdapter;
import com.example.jungjune.mypt.Item.TrainerItem;
import com.example.jungjune.mypt.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by triti on 2017-07-26.
 */

public class NoticeFragment extends Fragment {
    View v;
    Context context;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        context=getActivity();
        v = inflater.inflate(R.layout.fragment_notice, container, false);
        TextView textView = v.findViewById(R.id.context);
        Button close = v.findViewById(R.id.close);
        textView.setText("sdadsdasdsadasdsdadasdsadsad\ndsadqwdqdqwdqwdqwdqwdqwdqdq\n\n\n\n\ndadadsadasd\ndasdas");

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTransaction.remove(NoticeFragment.this);
            }
        });
        return v;
    }
    public void setFragment(FragmentManager fragmentManager, FragmentTransaction fragmentTransaction){
        this.fragmentManager = fragmentManager;
        this.fragmentTransaction = fragmentTransaction;
    }
}
