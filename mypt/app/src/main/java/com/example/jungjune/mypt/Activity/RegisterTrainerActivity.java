package com.example.jungjune.mypt.Activity;

import android.os.Bundle;

import com.example.jungjune.mypt.R;
import com.example.jungjune.mypt.Util.TextTitleActivity;

/**
 * Created by triti on 2017-07-13.
 */

public class RegisterTrainerActivity extends TextTitleActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setTitle(R.string.register);
        setContentView(R.layout.activity_register_trainer);
    }
}
