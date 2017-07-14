package com.example.jungjune.mypt.Activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jungjune.mypt.Fragment.MyPageTrainerFragment;
import com.example.jungjune.mypt.Fragment.MyPageUserFragment;
import com.example.jungjune.mypt.R;
import com.example.jungjune.mypt.Fragment.BestTabFragment;
import com.example.jungjune.mypt.Util.TitleBarActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends TitleBarActivity {
    FragmentManager fm;
    FragmentTransaction fragmentTransaction;
    MyPageUserFragment myPageTab;
    BestTabFragment bestTab;

    Button nowBtn;
    @BindView(R.id.search_bar)Button search;
    @BindView(R.id.bestBtn)Button best;
    @BindView(R.id.majchumBtn)Button majchum;
    @BindView(R.id.mypageBtn)Button mypage;
    @BindView(R.id.trainerBtn)Button trainer;

    @OnClick(R.id.bestBtn)
    public void setBest(){
        fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.contentPanel,bestTab);
        fragmentTransaction.commit();
        changeTab(best);
    }
    @OnClick(R.id.mypageBtn)
    public  void setMypage(){
        fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.contentPanel,myPageTab);
        fragmentTransaction.commit();
        changeTab(mypage);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        bestTab= new BestTabFragment();
        myPageTab= new MyPageUserFragment();


        fm = getFragmentManager();
        fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.contentPanel,bestTab);
        fragmentTransaction.commit();
        nowBtn= best;
    }
    public void changeTab(Button toBtn){
        nowBtn.setBackground(getDrawable(R.drawable.round_rantangle_white));
        nowBtn.setTextColor(Color.parseColor("#BDBDBD"));
        toBtn.setBackground(getDrawable(R.drawable.round_ractangle_skyblue));
        toBtn.setTextColor(Color.parseColor("#ffffff"));
        nowBtn=toBtn;
    }


}
