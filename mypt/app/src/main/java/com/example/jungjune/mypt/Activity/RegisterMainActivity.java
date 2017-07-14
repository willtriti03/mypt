package com.example.jungjune.mypt.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.jungjune.mypt.R;
import com.example.jungjune.mypt.Util.RoundImageView;
import com.example.jungjune.mypt.Util.TextTitleActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by triti on 2017-07-13.
 */

public class RegisterMainActivity extends TextTitleActivity {
    @BindView(R.id.registerPT)ImageView registerPt;
    @BindView(R.id.registerTrainer)ImageView registerTrainer;
    @BindView(R.id.fbBtn_User)LinearLayout fbBtn_User;
    @BindView(R.id.fbBtn_Trainer)LinearLayout fbBtn_Trainer;

    @OnClick(R.id.registerPT)
    public void  setRegisterPt(){
        startActivity(new Intent(RegisterMainActivity.this,AgreementActivity.class).putExtra("to","register"));
    }
    @OnClick(R.id.registerTrainer)
    public void setRegisterTrainer(){
        startActivity(new Intent(RegisterMainActivity.this,AgreementActivity.class).putExtra("to","trainer"));
    }
    @OnClick(R.id.fbBtn_User)
    public void  setFbBtn_User(){

    }
    @OnClick(R.id.fbBtn_Trainer)
    public void setFbBtn_Trainer(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setTitle(R.string.registerMain);
        setContentView(R.layout.activity_register_main);
        ButterKnife.bind(this);
    }
}
