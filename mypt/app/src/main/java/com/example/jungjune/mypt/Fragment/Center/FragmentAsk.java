package com.example.jungjune.mypt.Fragment.Center;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jungjune.mypt.R;
import com.example.jungjune.mypt.Util.TitleBarActivity;

/**
 * Created by choi on 2017. 7. 28..
 */

public class FragmentAsk extends Fragment {
    public FragmentAsk() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_ask,null);

        return view;
    }
}
