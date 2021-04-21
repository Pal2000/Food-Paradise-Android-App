
package com.example.foodparadise;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Rating extends AppCompatActivity {
    android.widget.RatingBar rbar;
    Button btn;

    int i=0;
    Handler h=new Handler(); // need for progress bar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        rbar = findViewById(R.id.rate);     // change the color of rating bar usng drawable file

        btn = findViewById(R.id.btn);


        FontChangeCrawler fontChanger = new FontChangeCrawler(getAssets(), "Comfortaa.ttf");
        fontChanger.replaceFonts((ViewGroup)this.findViewById(android.R.id.content));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater=getLayoutInflater(); // to call separate xml file
                View layout=inflater.inflate(R.layout.custom_toast, (ViewGroup)findViewById(R.id.toast_layout_root));
                TextView tv=layout.findViewById(R.id.toastTextView);
                Toast t=new Toast(getApplicationContext());
                tv.setText("Thankyou for your rating");

                Typeface face= Typeface.createFromAsset(getAssets(),"Comfortaa.ttf");
                tv.setTypeface(face);

                t.setDuration(Toast.LENGTH_LONG);
                t.setView(layout);
                t.show();

            }


        });

    }


}
