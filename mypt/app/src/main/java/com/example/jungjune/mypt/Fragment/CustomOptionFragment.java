package com.example.jungjune.mypt.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jungjune.mypt.R;

/**
 * Created by triti on 2017-07-18.
 */

public class CustomOptionFragment extends Fragment {
    Context context;
    View v;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();
        v = inflater.inflate(R.layout.fragment_custom_option, container, false);
        return v;
    }
}
