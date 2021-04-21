package com.example.foodparadise;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AlertDialog;

import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class perference extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener  {
    private DrawerLayout drawer;

    RadioButton r1, r2, r3;
    Button btn;
    String s="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perference);


        FontChangeCrawler fontChanger = new FontChangeCrawler(getAssets(), "Comfortaa.ttf");
        fontChanger.replaceFonts((ViewGroup)this.findViewById(android.R.id.content));

        r1=findViewById(R.id.breakfast);
        r2=findViewById(R.id.lunch);
        r3=findViewById(R.id.dinner);
        btn=findViewById(R.id.cont);
        Toolbar toolbar= findViewById(R.id.nav_toolbar);
//        setSupportActionBar(toolbar);
//
//        toolbar= findViewById(R.id.nav_toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(perference.this, drawer,toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

    }

    public void Continue(View view) {
        s="";
        if(r1.isChecked())
            s="Breakfast";
        else if(r2.isChecked())
            s="Lunch";
        else if(r3.isChecked())
            s="Dinner";
        else
            s="";
        AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(perference.this);
        builder.setTitle("Proceed")
                .setMessage("Are you sure, you want to continue ?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(s=="Breakfast") {
                            Intent intent = new Intent(getApplicationContext(), breakfast.class);
                            startActivity(intent);
                        }
                        else if(s=="Lunch"){
                            Intent intent = new Intent(getApplicationContext(), lunch.class);
                            startActivity(intent);
                        }
                        else if(s=="Dinner"){
                            Intent intent = new Intent(getApplicationContext(), dinner.class);
                            startActivity(intent);
                        }
                        else{
                            LayoutInflater inflater=getLayoutInflater(); // to call separate xml file
                            View layout=inflater.inflate(R.layout.custom_toast, (ViewGroup)findViewById(R.id.toast_layout_root));
                            TextView tv=layout.findViewById(R.id.toastTextView);
                            Toast t=new Toast(getApplicationContext());
                            tv.setText("Kindly select your meal type");

                            Typeface face= Typeface.createFromAsset(getAssets(),"Comfortaa.ttf");
                            tv.setTypeface(face);

                            t.setDuration(Toast.LENGTH_LONG);
                            t.setView(layout);
                            t.show();
                          //  Toast.makeText(getApplicationContext(),"Kindly select your meal type",Toast.LENGTH_LONG).show();
                        }
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        LayoutInflater inflater=getLayoutInflater(); // to call separate xml file
                        View layout=inflater.inflate(R.layout.custom_toast, (ViewGroup)findViewById(R.id.toast_layout_root));
                        TextView tv=layout.findViewById(R.id.toastTextView);
                        Toast t=new Toast(getApplicationContext());
                        tv.setText("Kindly select your meal type");
                        t.setDuration(Toast.LENGTH_LONG);

                        Typeface face= Typeface.createFromAsset(getAssets(),"Comfortaa.ttf");
                        tv.setTypeface(face);

                        t.setView(layout);
                        t.show();
                       // Toast.makeText(getApplicationContext(),"Kindly select your meal type",Toast.LENGTH_LONG).show();
                    }
                });

        //Creating dialog box
        AlertDialog dialog  = builder.create();
        dialog.show();

        TextView textView = (TextView) dialog.findViewById(android.R.id.message);
       // TextView textView2 = (TextView) dialog.findViewById(android.R.id.title);
        TextView  textView2= (TextView) dialog.getWindow().findViewById(R.id.alertTitle);
        Typeface face= Typeface.createFromAsset(getAssets(),"Comfortaa.ttf");
        textView.setTypeface(face);
        textView2.setTypeface(face);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.mag:
                getSupportFragmentManager().beginTransaction().replace(
                        R.id.frame_layout, new About()).addToBackStack(null).commit();
                break;
            case R.id.chats:
                getSupportFragmentManager().beginTransaction().replace(
                        R.id.frame_layout, new Account()).addToBackStack(null).commit();
                break;
            case R.id.Share:
                getSupportFragmentManager().beginTransaction().replace(
                        R.id.frame_layout, new Contact()).addToBackStack(null).commit();
                break;
            case R.id.Help:
                getSupportFragmentManager().beginTransaction().replace(
                        R.id.frame_layout, new privacy()).addToBackStack(null).commit();
                break;
            case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction().replace(
                        R.id.frame_layout, new Feedback()).addToBackStack(null).commit();
                break;
            case R.id.out:
                finish();
                finishAffinity();
                System.exit(0);
                break;
        }
         drawer.closeDrawer(GravityCompat.START);


        return true;
    }



}