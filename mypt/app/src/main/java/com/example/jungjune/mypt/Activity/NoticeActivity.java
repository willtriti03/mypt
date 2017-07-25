package com.example.jungjune.mypt.Activity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.jungjune.mypt.Adapter.NoticeAdapter;
import com.example.jungjune.mypt.R;
import com.example.jungjune.mypt.Util.TextTitleActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by triti on 2017-07-25.
 */

public class NoticeActivity extends TextTitleActivity {
    NoticeAdapter noticeAdapter;
    @BindView(R.id.noticeList)ListView noticeList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setTitle(R.string.notice);
        setContentView(R.layout.activity_notice);
        ButterKnife.bind(this);
        noticeAdapter =new  NoticeAdapter();
        noticeAdapter.addItem("시나는나아아아낭아ㅏ","2018.5.21","");
        noticeAdapter.addItem("시나는나아아아낭아ㅏ","2018.5.21","");
        noticeAdapter.addItem("시나는나아아아낭아ㅏ","2018.5.21","");
        noticeAdapter.addItem("시나는나아아아낭아ㅏ","2018.5.21","");
        noticeList.setAdapter(noticeAdapter);

    }
}
