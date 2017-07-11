package com.example.jungjune.mypt.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.example.jungjune.mypt.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jungjune on 2017-06-27.
 */

public class LoginActivity extends Activity{
    @BindView(R.id.loginBtn)Button loginBtn;
    @BindView(R.id.register)Button registerBtn;
    @BindView(R.id.findID)Button findBtn;
    @BindView(R.id.id_text)EditText idText;
    @BindView(R.id.password_text)EditText passText;

    @OnClick(R.id.loginBtn)
    public void login(){

    }

    @OnClick(R.id.register)
    public void register(){

    }

    @OnClick(R.id.findID)
    public void findID(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);


    }
}
