package com.example.jungjune.mypt.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Button;

import com.example.jungjune.mypt.Fragment.CustomSearch.CustomSearchFragment;
import com.example.jungjune.mypt.Fragment.MyPage.MyPageTrainerFragment;
import com.example.jungjune.mypt.Fragment.MyPage.MyPageUserFragment;
import com.example.jungjune.mypt.Fragment.TrainerMatching.TrainerMatchingFragment;
import com.example.jungjune.mypt.Fragment.TrainerMatching.TrainerMatchingNowFragment;
import com.example.jungjune.mypt.R;
import com.example.jungjune.mypt.Fragment.BestTab.BestTabFragment;
import com.example.jungjune.mypt.Util.TitleBarActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends TitleBarActivity {
    FragmentManager fm;
    FragmentTransaction fragmentTransaction;
    MyPageUserFragment myPageTab;
    CustomSearchFragment customSearchFragment;
    BestTabFragment bestTab;
    TrainerMatchingFragment trainerMatchingFragment;
    TrainerMatchingNowFragment trainerMatchingNowFragment;

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
    @OnClick(R.id.majchumBtn)
    public void setMajchum(){
        fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.contentPanel,customSearchFragment);
        fragmentTransaction.commit();
        changeTab(majchum);
    }
    @OnClick(R.id.mypageBtn)
    public  void setMypage(){
        fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.contentPanel,myPageTab);
        fragmentTransaction.commit();
        changeTab(mypage);
    }
    @OnClick(R.id.trainerBtn)
    public void setTrainer(){
        fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.contentPanel,trainerMatchingNowFragment);
        fragmentTransaction.commit();
        changeTab(trainer);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        bestTab= new BestTabFragment();
        myPageTab= new MyPageUserFragment();
        trainerMatchingFragment = new TrainerMatchingFragment();
        trainerMatchingNowFragment = new TrainerMatchingNowFragment();
        customSearchFragment = new CustomSearchFragment();

        fm = getSupportFragmentManager();
        fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.contentPanel,bestTab);
        fragmentTransaction.commit();
        nowBtn= best;

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
    public void changeTab(Button toBtn){
        nowBtn.setBackground(getDrawable(R.drawable.round_rantangle_white));
        nowBtn.setTextColor(Color.parseColor("#BDBDBD"));
        toBtn.setBackground(getDrawable(R.drawable.round_ractangle_skyblue));
        toBtn.setTextColor(Color.parseColor("#ffffff"));
        nowBtn=toBtn;
    }


}
