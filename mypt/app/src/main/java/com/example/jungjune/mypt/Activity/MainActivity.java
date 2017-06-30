package com.example.jungjune.mypt.Activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jungjune.mypt.R;
import com.example.jungjune.mypt.Fragment.BestTabFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends TitleBarActivity {
    @BindView(R.id.search_bar)Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        BestTabFragment bestTab= new BestTabFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.contentPanel,bestTab);
        fragmentTransaction.commit();


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

    }


}
