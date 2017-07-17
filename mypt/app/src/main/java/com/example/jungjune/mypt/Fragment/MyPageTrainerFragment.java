package com.example.jungjune.mypt.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jungjune.mypt.Adapter.MyPageAdabter;
import com.example.jungjune.mypt.Item.MyPageItem;
import com.example.jungjune.mypt.R;

import java.util.ArrayList;

/**
 * Created by jungjune on 2017-07-14.
 */

public class MyPageTrainerFragment extends Fragment {
    View v;
    Context context;
    private ArrayList<MyPageItem> listViewItemList = new ArrayList<MyPageItem>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context=getActivity();
        v = inflater.inflate(R.layout.fragment_mypage_trainer, container, false);
        setList();
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
