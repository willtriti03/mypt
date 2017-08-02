package com.example.jungjune.mypt.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jungjune.mypt.R;
import com.example.jungjune.mypt.Util.TextTitleActivity;
import com.example.jungjune.mypt.Util.TitleBarActivity;

public class ResultActivity extends TextTitleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setTitle("PT 결과");
        setContentView(R.layout.activity_result);
    }
}
