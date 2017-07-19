package com.example.jungjune.mypt.Activity;


import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.example.jungjune.mypt.Fragment.TrainerMatching.TrainerMatchingFragment;
import com.example.jungjune.mypt.R;
import com.example.jungjune.mypt.Util.TextTitleActivity;
import com.sangcomz.fishbun.FishBun;
import com.sangcomz.fishbun.define.Define;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by triti on 2017-07-19.
 */

public class ChangProfilmage extends TextTitleActivity{
    @BindView(R.id.imageView) ImageView profilImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setTitle(R.string.profil);
        setContentView(R.layout.activity_profil_change);
        ButterKnife.bind(this);

        View view = getLayoutInflater().inflate(R.layout.custom_plus,null);
        ActionBar ac= getSupportActionBar();
        ac.setCustomView(view);
        ac.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_SHOW_TITLE | ActionBar.DISPLAY_SHOW_CUSTOM|ActionBar.DISPLAY_HOME_AS_UP);
        RelativeLayout addImage = (RelativeLayout) view.findViewById(R.id.add);
        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FishBun.with(ChangProfilmage.this)
                        .MultiPageMode()
                        .setMaxCount(1)
                        .setMinCount(1)
                        .setActionBarColor(Color.parseColor("#029AE5"), Color.parseColor("#0286D0"), false)
                        .setActionBarTitleColor(Color.parseColor("#ffffff"))
                        .setActionBarTitle("사진을 선택해주세요")
                        .startAlbum();
            }
        });
        Button btn = (Button)view.findViewById(R.id.plus);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FishBun.with(ChangProfilmage.this)
                        .MultiPageMode()
                        .setMaxCount(1)
                        .setMinCount(1)
                        .setActionBarColor(Color.parseColor("#029AE5"), Color.parseColor("#0286D0"), false)
                        .setActionBarTitleColor(Color.parseColor("#ffffff"))
                        .setActionBarTitle("사진을 선택해주세요")
                        .startAlbum();
            }
        });

    }

    public void onActivityResult(int requestCode, int resultCode, Intent imageData) {
        super.onActivityResult(requestCode, resultCode, imageData);
        switch (requestCode) {
            case Define.ALBUM_REQUEST_CODE:
                if (resultCode == RESULT_OK) {
                    ArrayList<Uri> path = imageData.getParcelableArrayListExtra(Define.INTENT_PATH);
                    Glide.with(this)
                            .load(getRealPathFromURI(path.get(0)))
                            .centerCrop()
                            .into(profilImg);
                    break;
                }
        }
    }
    public String getRealPathFromURI(Uri contentUri) {
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = managedQuery(contentUri, proj, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);

    }
}
