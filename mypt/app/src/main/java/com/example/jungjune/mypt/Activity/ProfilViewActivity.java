package com.example.jungjune.mypt.Activity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.jungjune.mypt.Adapter.MyPageAdabter;
import com.example.jungjune.mypt.R;
import com.example.jungjune.mypt.Util.TextTitleActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by triti on 2017-07-25.
 */

public class ProfilViewActivity extends TextTitleActivity {
    @BindView(R.id.myPageList)ListView myPageList;
    MyPageAdabter adabter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setTitle(R.string.profilView);
        setContentView(R.layout.activity_profil_view);
        ButterKnife.bind(this);
        adabter = new MyPageAdabter();
        adabter.addItem(getDrawable(R.drawable.ic_myp_ptresult),"PT 결과","result");
        adabter.addItem(getDrawable(R.drawable.ic_myp_review),"익명 후기 보기","review");
        adabter.addItem(getDrawable(R.drawable.ic_myp_spec),"스펙","spec");
        myPageList.setAdapter(adabter);

    }
}
