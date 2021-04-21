package com.example.foodparadise;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    Handler h;
    Runnable r;
    Long t=3000L;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);


        FontChangeCrawler fontChanger = new FontChangeCrawler(getAssets(), "Comfortaa.ttf");
        fontChanger.replaceFonts((ViewGroup)this.findViewById(android.R.id.content));

        h= new Handler();
        r=new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        h.postDelayed(r, t);
        t=System.currentTimeMillis();
    }

    @Override
    protected void onStop(){
        super.onStop();
        h.removeCallbacks(r);
    }
}