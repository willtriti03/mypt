package com.example.jungjune.mypt.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jungjune.mypt.R;
import com.example.jungjune.mypt.Util.TextTitleActivity;
import com.example.jungjune.mypt.Util.TitleBarActivity;

public class EventDetailActivity extends TextTitleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setTitle("이벤트 세부 보기");
        setContentView(R.layout.activity_event_detail);
    }
}
