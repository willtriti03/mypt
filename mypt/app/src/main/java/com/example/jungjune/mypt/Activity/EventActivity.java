package com.example.jungjune.mypt.Activity;

import android.os.Bundle;

import com.example.jungjune.mypt.R;
import com.example.jungjune.mypt.Util.TextTitleActivity;

import butterknife.ButterKnife;

/**
 * Created by jungjune on 2017-07-23.
 */

public class EventActivity extends TextTitleActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setTitle(R.string.event);
        ButterKnife.bind(this);

    }
}
