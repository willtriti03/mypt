package com.example.jungjune.mypt.Activity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.jungjune.mypt.Adapter.EventAdapter;
import com.example.jungjune.mypt.R;
import com.example.jungjune.mypt.Util.TextTitleActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jungjune on 2017-07-23.
 */

public class EventActivity extends TextTitleActivity {
    EventAdapter adapter;
    @BindView(R.id.eventList)ListView eventListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setTitle(R.string.event);
        setContentView(R.layout.activity_event);
        ButterKnife.bind(this);

        adapter = new EventAdapter();
        eventListView.setAdapter(adapter);
        adapter.addItem("R.drawable.aaasss","김지원 이뻐용 ><", "2017.5.6");
        adapter.addItem("R.drawable.aaasss","김지원 이뻐용 ><", "2017.5.6");
        adapter.addItem("R.drawable.aaasss","김지원 이뻐용 ><", "2017.5.6");
        adapter.addItem("R.drawable.aaasss","김지원 이뻐용 ><", "2017.5.6");
        adapter.addItem("R.drawable.aaasss","김지원 이뻐용 ><", "2017.5.6");
        adapter.notifyDataSetChanged();
    }
}
