package com.example.foodparadise;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Contact extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.contact, container, false);
//        FontChangeCrawler fontChanger = new FontChangeCrawler(getContext().getAssets(), "Comfortaa.ttf");
//        fontChanger.replaceFonts((ViewGroup) this.getView());

        TextView tv1, tv2, head, tv3;
        head=rootView.findViewById(R.id.head);
        tv1=rootView.findViewById(R.id.t1);
        tv2=rootView.findViewById(R.id.t2);
        tv3=rootView.findViewById(R.id.t3);
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "Comfortaa.ttf");
        tv1.setTypeface(font);
        tv2.setTypeface(font);
        tv3.setTypeface(font);
        head.setTypeface(font);

        return rootView;
    }
}
