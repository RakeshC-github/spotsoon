package com.betamonks.spotsoontest.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.betamonks.spotsoontest.R;


/**
 * Created by bm-admin on 19/12/16.
 */
public class TestFragement extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.events, container, false);
        Log.d("Events","fragment"+view);
        return view;
    }
}
