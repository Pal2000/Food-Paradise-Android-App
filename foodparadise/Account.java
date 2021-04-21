package com.example.foodparadise;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Account extends Fragment  {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.account, container, false);

        SharedPreferences prefs = getContext().getSharedPreferences("myfile", Context.MODE_PRIVATE);
        String email = prefs.getString("myemailkey", "");
        String pass= prefs.getString("mypasswordkey", "");
        String UserName = prefs.getString("mynamekey", "");
        String UserPhone= prefs.getString("myphonekey", "");
        TextView name, passtv, emailtv, phone;
        name=rootView.findViewById(R.id.name);
        phone=rootView.findViewById(R.id.phone);
        emailtv=rootView.findViewById(R.id.email);
        passtv=rootView.findViewById(R.id.pass);
        emailtv.setText("Email : "+email);
        passtv.setText("Password : "+pass);
        name.setText("Name : "+UserName);
        phone.setText("Phone : "+UserPhone);

        TextView head;
        head=rootView.findViewById(R.id.head);

        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "Comfortaa.ttf");
        name.setTypeface(font);
        emailtv.setTypeface(font);
        phone.setTypeface(font);
        passtv.setTypeface(font);
        head.setTypeface(font);


        return rootView;
    }

}
