package com.example.jungjune.mypt.Activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.jungjune.mypt.Fragment.Utilty.ListFragment;
import com.example.jungjune.mypt.R;
import com.example.jungjune.mypt.Util.TextTitleActivity;

import butterknife.ButterKnife;

/**
 * Created by triti on 2017-07-23.
 */

public class ILikeItActivity extends TextTitleActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setTitle(R.string.likeIt);
        setContentView(R.layout.actvity_i_like_it);
        ButterKnife.bind(this);

        ListFragment fragment2 = new ListFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment2);
        fragmentTransaction.commit();

    }
}
