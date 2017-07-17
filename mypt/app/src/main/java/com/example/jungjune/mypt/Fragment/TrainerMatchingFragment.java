package com.example.jungjune.mypt.Fragment;


import android.app.Notification;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.jungjune.mypt.Activity.MainActivity;
import com.example.jungjune.mypt.Adapter.ImageSlideAdabter;
import com.example.jungjune.mypt.R;

import java.io.File;
import java.util.ArrayList;

import gun0912.tedbottompicker.TedBottomPicker;

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
    TedBottomPicker bottomSheetDialogFragment;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();
        v = inflater.inflate(R.layout.fragment_trainermatching, container, false);
        adabter = new ImageSlideAdabter(context);
        recyclerView = (RecyclerView) v.findViewById(R.id.imageSlide);
        Button addImage = (Button) v.findViewById(R.id.addImage);


        bottomSheetDialogFragment = new TedBottomPicker.Builder(context.getApplicationContext())
                .setOnMultiImageSelectedListener(new TedBottomPicker.OnMultiImageSelectedListener() {
                    @Override
                    public void onImagesSelected(ArrayList<Uri> uriList) {
                        // here is selected uri list
                    }
                })
                .setPeekHeight(1600)
                .showTitle(false)
                .setCompleteButtonText("Done")
                .setEmptySelectionText("No Select")
                .create();
        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialogFragment.show(getFragmentManager());
            }
        });

        return v;
    }

    public String getRealPathFromURI(Uri contentUri) {
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getActivity().managedQuery(contentUri, proj, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);

    }


}
