package com.example.jungjune.mypt.Activity;

import android.os.Bundle;

import com.example.jungjune.mypt.R;

/**
 * Created by triti on 2017-07-07.
 */

public class RegisterActivity extends TextTitleActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setTitle(R.string.changeInform);
        setContentView(R.layout.activity_edit_inform);
    }
}
