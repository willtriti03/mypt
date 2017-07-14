package com.example.jungjune.mypt.Activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.jungjune.mypt.R;
import com.example.jungjune.mypt.Util.TextTitleActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by triti on 2017-07-13.
 */

public class AgreementActivity extends TextTitleActivity {
    @OnClick(R.id.commit)
    public void agreed(){
        String target = getIntent().getStringExtra("to");
        if(target.equals("register")){
            startActivity(new Intent(AgreementActivity.this, RegisterActivity.class));
        }
        else if(target.equals("trainer")){
            startActivity(new Intent(AgreementActivity.this, RegisterTrainerActivity.class));
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setTitle(R.string.agreement);
        setContentView(R.layout.activity_agreement);
        ButterKnife.bind(this);
    }
}
