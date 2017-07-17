package com.example.jungjune.mypt.Fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.jungjune.mypt.Adapter.ImageSlideAdabter;
import com.example.jungjune.mypt.Item.MyPageItem;
import com.example.jungjune.mypt.R;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;

/**
 * Created by triti on 2017-07-14.
 */

public class TrainerMatchingFragment extends Fragment {
    int GALLERYCODE = 444;
    View v;
    Context context;
    ImageView imageView;
    RecyclerView recyclerView;
    ImageSlideAdabter adabter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context=getActivity();
        v = inflater.inflate(R.layout.fragment_trainermatching, container, false);
        adabter= new ImageSlideAdabter();
        recyclerView =(RecyclerView)v.findViewById(R.id.imageSlide);
        Button addImage = (Button)v.findViewById(R.id.addImage);
        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                intent.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), GALLERYCODE);
            }
        });

        recyclerView.setAdapter(adabter);
        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                default:
                    /*
                    ClipData clipData = data.getClipData();
                    for (int i = 0; i < clipData.getItemCount(); i++)
                    {
                        Uri imgUri = clipData.getItemAt(i).getUri();
                        String imagePath = getRealPathFromURI(imgUri);
                        adabter.addItem(imagePath);
                        adabter.notifyDataSetChanged();
                    }
*/
                    break;
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
