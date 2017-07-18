package com.example.jungjune.mypt.Fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.jungjune.mypt.R;

/**
 * Created by triti on 2017-07-18.
 */

public class FilterFragment extends Fragment {
    Context context;
    View v;
    TextView items;
    String option1T, option2T, option3T;
    Button option1, option2, option3, nowBtn;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    CustomOptionFragment customOptionFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();
        v = inflater.inflate(R.layout.fragment_filter, container, false);
        items = (TextView) v.findViewById(R.id.items);
        option1 = (Button) v.findViewById(R.id.option1);
        option2 = (Button) v.findViewById(R.id.option2);
        option3 = (Button) v.findViewById(R.id.option3);
        option1.setText(option1T);
        option2.setText(option2T);
        option3.setText(option3T);

        nowBtn = option1;

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeOption(option1);
                changeToCustomOption();
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeOption(option2);
            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeOption(option3);
            }
        });


        return v;
    }

    public void changeOption(Button chage) {
        nowBtn.setTextColor(Color.parseColor("#757575"));
        nowBtn.setBackground(context.getDrawable(R.drawable.round_rantangle_white));
        chage.setTextColor(Color.parseColor("#ffffff"));
        chage.setBackground(context.getDrawable(R.drawable.round_ractangle_skyblue));
        nowBtn = chage;
    }

    public void setName(String option1, String option2, String option3) {
        option1T = option1;
        option2T = option2;
        option3T = option3;

    }

    public void setFragment(FragmentManager fm, FragmentTransaction ft, CustomOptionFragment cf) {
        fragmentManager = fm;
        fragmentTransaction = ft;
        customOptionFragment = cf;
    }

    public void changeToCustomOption() {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.option, customOptionFragment);
        fragmentTransaction.commit();
    }

}
