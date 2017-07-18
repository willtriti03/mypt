package com.example.jungjune.mypt.Fragment;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.jungjune.mypt.R;
import com.sangcomz.fishbun.FishBun;
import com.sangcomz.fishbun.define.Define;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

/**
 * Created by triti on 2017-07-14.
 */

public class TrainerMatchingFragment extends Fragment {
    final int GALLERYCODE = 444;
    int width;
    int height;
    View v;
    Context context;
    ArrayList<ImageView> imgArr = new ArrayList<ImageView>();
    LinearLayout.LayoutParams params;
    LinearLayout imgScroll;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();
        v = inflater.inflate(R.layout.fragment_trainermatching, container, false);
        width =dpToPx(80);
        height = dpToPx(60);
        Button addImage = (Button) v.findViewById(R.id.addImage);
        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FishBun.with(TrainerMatchingFragment.this)
                        .MultiPageMode()
                        .setMaxCount(5)
                        .setMinCount(1)
                        .setActionBarColor(Color.parseColor("#029AE5"), Color.parseColor("#0286D0"), false)
                        .setActionBarTitleColor(Color.parseColor("#ffffff"))
                        .setActionBarTitle("사진을 선택해주세요")
                        .startAlbum();
            }
        });
        imgScroll= (LinearLayout)v.findViewById(R.id.imgScroll);
        params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.width = dpToPx(120);
        params.height = dpToPx(90);
        params.rightMargin =dpToPx(5);
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        imgArr.clear();
    }

    public void onActivityResult(int requestCode, int resultCode,
                                 Intent imageData) {
        super.onActivityResult(requestCode, resultCode, imageData);
        switch (requestCode) {
            case Define.ALBUM_REQUEST_CODE:
                if (resultCode == RESULT_OK) {
                    //path = imageData.getStringArrayListExtra(Define.INTENT_PATH);
                    //You can get image path(ArrayList<String>) Under version 0.6.2
                    imgArr.clear();
                    imgScroll.removeAllViews();
                    ArrayList<Uri> path = imageData.getParcelableArrayListExtra(Define.INTENT_PATH);
                    for (int i=0; i<path.size(); ++i){
                        CardView card = new CardView(context);
                        card.setLayoutParams(params);
                        card.setRadius(15);

                        ImageView img = new ImageView(context);
                        img.setLayoutParams(params);

                        card.addView(img);
                        imgScroll.addView(card);
                        imgArr.add(img);
                        Glide.with(this).load(getRealPathFromURI(path.get(i))).centerCrop().into(img);
                    }

                }
        }
    }
    public String getRealPathFromURI(Uri contentUri) {
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getActivity().managedQuery(contentUri, proj, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);

    }
    public int dpToPx(int dp) {
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

}
