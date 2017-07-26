package com.example.jungjune.mypt.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
    @BindView(R.id.search_bar)
    Button search;
    @BindView(R.id.bestBtn)
    Button best;
    @BindView(R.id.majchumBtn)
    Button majchum;
    @BindView(R.id.mypageBtn)
    Button mypage;
    @BindView(R.id.trainerBtn)
    Button trainer;
    @BindView(R.id.contentPanel)
    ViewPager vp;

    @OnClick(R.id.bestBtn)
    public void setBest() {
        int tag = (int) best.getTag();
        vp.setCurrentItem(tag);
        changeTab(best);
    }

    @OnClick(R.id.majchumBtn)
    public void setMajchum() {
        int tag = (int) majchum.getTag();
        vp.setCurrentItem(tag);
        changeTab(majchum);
    }

    @OnClick(R.id.mypageBtn)
    public void setMypage() {
        int tag = (int) mypage.getTag();
        vp.setCurrentItem(tag);
        changeTab(mypage);
    }

    @OnClick(R.id.trainerBtn)
    public void setTrainer() {
        int tag = (int) trainer.getTag();
        vp.setCurrentItem(tag);
        changeTab(trainer);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        bestTab = new BestTabFragment();
        myPageTab = new MyPageUserFragment();
        trainerMatchingFragment = new TrainerMatchingFragment();
        trainerMatchingNowFragment = new TrainerMatchingNowFragment();
        customSearchFragment = new CustomSearchFragment();

        best.setTag(0);
        majchum.setTag(1);
        trainer.setTag(2);
        mypage.setTag(3);

        vp.setAdapter(new pagerAdapter(fm = getSupportFragmentManager()));
        nowBtn = best;

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                changeTab();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void changeTab(Button toBtn) {
        nowBtn.setBackground(getDrawable(R.drawable.round_rantangle_white));
        nowBtn.setTextColor(Color.parseColor("#BDBDBD"));
        toBtn.setBackground(getDrawable(R.drawable.round_ractangle_skyblue));
        toBtn.setTextColor(Color.parseColor("#ffffff"));

        nowBtn = toBtn;
    }

    public void changeTab() {
        nowBtn.setBackground(getDrawable(R.drawable.round_rantangle_white));
        nowBtn.setTextColor(Color.parseColor("#BDBDBD"));
        Button toBtn = null;
        switch (vp.getCurrentItem()) {
            case 0:
                toBtn = best;
                break;
            case 1:
                toBtn = majchum;
                break;
            case 2:
                toBtn = trainer;
                break;
            case 3:
                toBtn = mypage;
                break;
        }
        toBtn.setBackground(getDrawable(R.drawable.round_ractangle_skyblue));
        toBtn.setTextColor(Color.parseColor("#ffffff"));

        nowBtn = toBtn;
    }


    private class pagerAdapter extends FragmentStatePagerAdapter {
        public pagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return bestTab;
                case 1:
                    return customSearchFragment;
                case 2:
                    return trainerMatchingNowFragment;
                case 3:
                    return myPageTab;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}



