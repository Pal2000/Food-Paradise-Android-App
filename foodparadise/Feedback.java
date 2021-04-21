package com.example.foodparadise;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class Feedback extends Fragment{

    public Button b;
    EditText ed1, ed2, ed3;
    CheckBox chb;
    TextView head;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.feedback, container, false);

        b = (Button) rootView.findViewById(R.id.btn);
        ed1 = rootView.findViewById(R.id.name);
        ed2 = rootView.findViewById(R.id.email);
        ed3 = rootView.findViewById(R.id.feed);
        chb = rootView.findViewById(R.id.cb);
        head = rootView.findViewById(R.id.head);


        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "Comfortaa.ttf");
        ed1.setTypeface(font);
        ed2.setTypeface(font);
        b.setTypeface(font);
        ed3.setTypeface(font);
        chb.setTypeface(font);
        head.setTypeface(font);
//        FontChangeCrawler fontChanger = new FontChangeCrawler(getContext().getAssets(), "Comfortaa.ttf");
//        fontChanger.replaceFonts((ViewGroup) this.getView());



//        b.setOnClickListener(this);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int f=0;
                String s = "";
                if (!ed1.getText().toString().isEmpty()) {
                    s += " Name - " + ed1.getText().toString();
                } else f=1;

                if (!ed2.getText().toString().isEmpty()) {
                    s += "\n Email - " + ed2.getText().toString();
                } else f=1;

                if (!ed3.getText().toString().isEmpty()) {
                    s += "\n Feedback - " + ed3.getText().toString();
                } else f=1;

                if(f==1 || !chb.isChecked() || s.isEmpty()) {
                    if (!chb.isChecked()) {
                        LayoutInflater inflater=getLayoutInflater(); // to call separate xml file
                        View layout=inflater.inflate(R.layout.custom_toast, (ViewGroup)getActivity().findViewById(R.id.toast_layout_root));
                        TextView tv=layout.findViewById(R.id.toastTextView);
                        Toast t=new Toast(getContext());
                        tv.setText("Kindly select the given checkbox");

                        Typeface face= Typeface.createFromAsset(getContext().getAssets(),"Comfortaa.ttf");
                        tv.setTypeface(face);

                        t.setDuration(Toast.LENGTH_LONG);
                        t.setView(layout);
                        t.show();
                       // Toast.makeText(getContext(), "Kindly select the given checkbox", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        LayoutInflater inflater=getLayoutInflater(); // to call separate xml file
                        View layout=inflater.inflate(R.layout.custom_toast, (ViewGroup)getActivity().findViewById(R.id.toast_layout_root));
                        TextView tv=layout.findViewById(R.id.toastTextView);
                        Toast t=new Toast(getContext());
                        tv.setText("Kindly fill your details");

                        Typeface face= Typeface.createFromAsset(getContext().getAssets(),"Comfortaa.ttf");
                        tv.setTypeface(face);

                        t.setDuration(Toast.LENGTH_LONG);
                        t.setView(layout);
                        t.show();
                        //Toast.makeText(getContext(), "Kindly fill your details", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(chb.isChecked() && !s.isEmpty()) {
                    LayoutInflater inflater=getLayoutInflater(); // to call separate xml file
                    View layout=inflater.inflate(R.layout.custom_toast, (ViewGroup)getActivity().findViewById(R.id.toast_layout_root));
                    TextView tv=layout.findViewById(R.id.toastTextView);
                    Toast t=new Toast(getContext());
                    tv.setText("Thankyou for your feedback");

                    Typeface face= Typeface.createFromAsset(getContext().getAssets(),"Comfortaa.ttf");
                    tv.setTypeface(face);

                    t.setDuration(Toast.LENGTH_LONG);
                    t.setView(layout);
                    t.show();
                   // Toast.makeText(getContext(), "Thankyou for your feedback", Toast.LENGTH_LONG).show();
                }
            }
        });
        return rootView;
    }

}

