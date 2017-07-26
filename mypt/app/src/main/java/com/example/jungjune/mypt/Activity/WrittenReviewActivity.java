package com.example.jungjune.mypt.Activity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.jungjune.mypt.Adapter.WrittenReviewAdapter;
import com.example.jungjune.mypt.R;
import com.example.jungjune.mypt.Util.TextTitleActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jungjune on 2017-07-26.
 */

public class WrittenReviewActivity extends TextTitleActivity {
    @BindView(R.id.reviewList)ListView reviewListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setTitle(R.string.wirttenReview);
        setContentView(R.layout.activity_written_review);
        ButterKnife.bind(this);
        WrittenReviewAdapter writtenReviewAdapter= new WrittenReviewAdapter();
        writtenReviewAdapter.addItem("image","암욜맨","안녕하세요 감사해요 잘있어요 다시 만나요 아침해가 뜨면~\n랄라라라라라라라라라라라라","1시간","ㅁㄴㅇ");
        writtenReviewAdapter.addItem("image","암욜맨","안녕하세요 감사해요 잘있어요 다시 만나요 아침해가 뜨면~\n랄라라라라라라라라라라라라","2시간","ㅁㄴㅇ");
        writtenReviewAdapter.addItem("image","암욜맨","안녕하세요 감사해요 잘있어요 다시 만나요 아침해가 뜨면~\n랄라라라라라라라라라라라라","3시간","ㅁㄴㅇ");
        writtenReviewAdapter.addItem("image","암욜맨","안녕하세요 감사해요 잘있어요 다시 만나요 아침해가 뜨면~\n랄라라라라라라라라라라라라","3시간","ㅁㄴㅇ");
        writtenReviewAdapter.addItem("image","암욜맨","안녕하세요 감사해요 잘있어요 다시 만나요 아침해가 뜨면~\n랄라라라라라라라라라라라라","3시간","ㅁㄴㅇ");
        writtenReviewAdapter.addItem("image","암욜맨","안녕하세요 감사해요 잘있어요 다시 만나요 아침해가 뜨면~\n랄라라라라라라라라라라라라","3시간","ㅁㄴㅇ");
        writtenReviewAdapter.addItem("image","암욜맨","안녕하세요 감사해요 잘있어요 다시 만나요 아침해가 뜨면~\n랄라라라라라라라라라라라라","3시간","ㅁㄴㅇ");
        writtenReviewAdapter.addItem("image","암욜맨","안녕하세요 감사해요 잘있어요 다시 만나요 아침해가 뜨면~\n랄라라라라라라라라라라라라","3시간","ㅁㄴㅇ");
        writtenReviewAdapter.addItem("image","암욜맨","안녕하세요 감사해요 잘있어요 다시 만나요 아침해가 뜨면~\n랄라라라라라라라라라라라라","3시간","ㅁㄴㅇ");
        writtenReviewAdapter.addItem("image","암욜맨","안녕하세요 감사해요 잘있어요 다시 만나요 아침해가 뜨면~\n랄라라라라라라라라라라라라","3시간","ㅁㄴㅇ");

        reviewListView.setAdapter(writtenReviewAdapter);
    }
}
