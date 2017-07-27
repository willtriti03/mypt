package com.example.jungjune.mypt.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.widget.Button;
import android.widget.Toast;

import com.example.jungjune.mypt.Fragment.BestTab.BestTabFragment;
import com.example.jungjune.mypt.Fragment.CustomSearch.CustomSearchFragment;
import com.example.jungjune.mypt.Fragment.MyPage.MyPageTrainerFragment;
import com.example.jungjune.mypt.Fragment.MyPage.MyPageUserFragment;
import com.example.jungjune.mypt.Fragment.SearchCunsumer.SearchCunsumerFragment;
import com.example.jungjune.mypt.Fragment.TrainerMatching.TrainerMatchingFragment;
import com.example.jungjune.mypt.R;
import com.example.jungjune.mypt.Util.TitleBarActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by triti on 2017-07-19.
 */

public class MainTrainerActivity extends TitleBarActivity {
    FragmentManager fm;
    MyPageTrainerFragment myPageTabTrainer;
    CustomSearchFragment customSearchFragment;
    BestTabFragment bestTab;
    SearchCunsumerFragment searchCunsumerFragment;

    Button nowBtn;
    @BindView(R.id.search_bar)Button search;
    @BindView(R.id.bestBtn)Button best;
    @BindView(R.id.majchumBtn)Button majchum;
    @BindView(R.id.mypageBtn)Button mypage;
    @BindView(R.id.search_Cunsumer)Button searchCunsumer;
    @OnClick(R.id.bestBtn)
    public void setBest(){
        fm.beginTransaction().replace(R.id.contentPanel,bestTab).commit();
        changeTab(best);
    }
    @OnClick(R.id.majchumBtn)
    public void setMajchum(){
        fm.beginTransaction().replace(R.id.contentPanel,customSearchFragment).commit();
        changeTab(majchum);
    }
    @OnClick(R.id.mypageBtn)
    public  void setMypage(){
        fm.beginTransaction().replace(R.id.contentPanel,myPageTabTrainer).commit();
        changeTab(mypage);
    }

    @OnClick(R.id.search_Cunsumer)
    public  void setSearchCunsumer(){
        fm.beginTransaction().replace(R.id.contentPanel,searchCunsumerFragment).commit();
        changeTab(searchCunsumer);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_trainer);
        ButterKnife.bind(this);

        bestTab= new BestTabFragment();
        myPageTabTrainer = new MyPageTrainerFragment();
        customSearchFragment = new CustomSearchFragment();
        searchCunsumerFragment = new SearchCunsumerFragment();

        fm=getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.contentPanel,bestTab).commit();
        nowBtn = best;

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

