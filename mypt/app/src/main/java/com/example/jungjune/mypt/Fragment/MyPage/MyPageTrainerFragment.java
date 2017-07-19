package com.example.jungjune.mypt.Fragment.MyPage;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.example.jungjune.mypt.Activity.ChangProfilmage;
import com.example.jungjune.mypt.Adapter.MyPageAdabter;
import com.example.jungjune.mypt.Item.MyPageItem;
import com.example.jungjune.mypt.R;
import com.sangcomz.fishbun.FishBun;
import com.sangcomz.fishbun.define.Define;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

/**
 * Created by jungjune on 2017-07-14.
 */

public class MyPageTrainerFragment extends Fragment {
    View v;
    Context context;
    ImageView profilImg;
    private ArrayList<MyPageItem> listViewItemList = new ArrayList<MyPageItem>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context=getActivity();
        v = inflater.inflate(R.layout.fragment_mypage_trainer, container, false);
        setList();
        profilImg= (ImageView)v.findViewById(R.id.profil_image);
        profilImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              startActivity(new Intent(context, ChangProfilmage.class));
            }
        });

        return v;
    }

    public void setList(){
        ListView lv =  v.findViewById(R.id.myPageList);
        MyPageAdabter myPageAdabter= new MyPageAdabter();
        myPageAdabter.notifyDataSetChanged();
        myPageAdabter.addItem(context.getDrawable(R.drawable.ic_myp_ptresult),"PT 결과","result");
        myPageAdabter.addItem(context.getDrawable(R.drawable.ic_myp_review),"익명 후기 보기","review");
        myPageAdabter.addItem(context.getDrawable(R.drawable.ic_myp_spec),"스펙","spec");
        myPageAdabter.addItem(context.getDrawable(R.drawable.ic_myp_notice),"공지사항","notice");
        myPageAdabter.addItem(context.getDrawable(R.drawable.ic_myp_cs),"고객센터","callcenter");
        myPageAdabter.addItem(context.getDrawable(R.drawable.ic_myp_event),"이벤트","event");
        lv.setAdapter(myPageAdabter);
    }
}
