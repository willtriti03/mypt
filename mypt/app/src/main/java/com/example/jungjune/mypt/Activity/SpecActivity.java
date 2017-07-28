package com.example.jungjune.mypt.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.jungjune.mypt.R;
import com.example.jungjune.mypt.Util.TextTitleActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jungjune on 2017-07-28.
 */

public class SpecActivity extends TextTitleActivity{
    Intent intent;
    @BindView(R.id.spec_people)TextView specPeople;
    @BindView(R.id.spec_career)TextView specCareer;
    @BindView(R.id.spec_lisence)TextView specLisence;
    @BindView(R.id.spec_prize)TextView specPrize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setTitle(R.string.spec);
        setContentView(R.layout.activity_spec);
        ButterKnife.bind(this);
        intent = getIntent();
        specPeople.setText(intent.getStringExtra("people")+"명");
        specCareer.setText(intent.getStringExtra("career")+"년");
        specLisence.setText(intent.getStringExtra("lisence"));
        specPrize.setText(intent.getStringExtra("prize"));


    }
}
