package com.example.jungjune.mypt.Fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jungjune.mypt.Item.MyPageItem;
import com.example.jungjune.mypt.R;

import java.util.ArrayList;

/**
 * Created by triti on 2017-07-14.
 */

public class TrainerMatchingFragment extends Fragment {
    View v;
    Context context;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context=getActivity();
        v = inflater.inflate(R.layout.fragment_trainermatching, container, false);
        return v;
    }
}
