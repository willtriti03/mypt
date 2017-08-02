package com.example.jungjune.mypt.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jungjune.mypt.R;
import com.example.jungjune.mypt.Util.TextTitleActivity;
import com.example.jungjune.mypt.Util.TitleBarActivity;

import org.w3c.dom.Text;

public class    ReviewListActivity extends TextTitleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setTitle("익명 후기 보기");
        setContentView(R.layout.activity_review_list);
    }
}
