package com.example.basha.fragmentinloginpg.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.basha.fragmentinloginpg.R;

/**
 * Created by basha on 3/15/2017.
 */

public class FragmentThree extends Fragment {

    public FragmentThree() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
    return inflater.inflate(R.layout.fragment_three,container,false);
    }
}
