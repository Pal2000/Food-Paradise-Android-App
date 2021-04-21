package com.example.foodparadise;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class About extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.about, container, false);
        TextView tv1=rootView.findViewById(R.id.t1);
        TextView tv2=rootView.findViewById(R.id.t2);
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "Comfortaa.ttf");
        tv1.setTypeface(font);
        tv2.setTypeface(font);

        return rootView;
    }
}

