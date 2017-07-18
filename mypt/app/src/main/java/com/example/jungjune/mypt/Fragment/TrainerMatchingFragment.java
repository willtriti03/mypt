package com.example.jungjune.mypt.Fragment;


import android.app.Notification;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.jungjune.mypt.Activity.MainActivity;
import com.example.jungjune.mypt.Adapter.ImageSlideAdabter;
import com.example.jungjune.mypt.Item.ImageSlideItem;
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
    View v;
    Context context;
    RecyclerView recyclerView;
    ImageSlideAdabter adabter;
    LinearLayoutManager layoutManager;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();
        v = inflater.inflate(R.layout.fragment_trainermatching, container, false);
        layoutManager = new LinearLayoutManager(context.getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        adabter = new ImageSlideAdabter(context);

        recyclerView = (RecyclerView) v.findViewById(R.id.imageSlide);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adabter);

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

        return v;
    }
    public void onActivityResult(int requestCode, int resultCode,
                                    Intent imageData) {
        super.onActivityResult(requestCode, resultCode, imageData);
        switch (requestCode) {
            case Define.ALBUM_REQUEST_CODE:
                if (resultCode == RESULT_OK) {
                    //path = imageData.getStringArrayListExtra(Define.INTENT_PATH);
                    //You can get image path(ArrayList<String>) Under version 0.6.2
                    ArrayList<Uri> path = imageData.getParcelableArrayListExtra(Define.INTENT_PATH);
                    for (int i=0; i<path.size(); ++i){
                        adabter.addItem(getRealPathFromURI(path.get(i)));
                        adabter.notifyDataSetChanged();
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


}
