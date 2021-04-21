package com.example.foodparadise;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import static android.graphics.Color.*;

public class breakfast extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener   {
    private DrawerLayout drawer;


   // final GlobalClass globalVariable = (GlobalClass)getApplication();
    Button b1,b2,b3,b4,b5,b6,b7,b8, proceed;
    TextView et;
    int prices[]={150,250,200,110,200,350,230,190};
    //final int sumtotal  = globalVariable.getsum();
   // int total=sumtotal;
    int total=0;
   int flg1=0, flg2=0, flg3=0, flg4=0, flg5=0, flg6=0, flg7=0, flg8=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast);


        FontChangeCrawler fontChanger = new FontChangeCrawler(getAssets(), "Comfortaa.ttf");
        fontChanger.replaceFonts((ViewGroup)this.findViewById(android.R.id.content));

        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        b6=findViewById(R.id.b6);
        b7=findViewById(R.id.b7);
        b8=findViewById(R.id.b8);
        proceed=findViewById(R.id.pro);
        et=findViewById(R.id.ed);



        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String sum="";

                if(flg1==0) {
                    flg1=1;
                    b1.setBackgroundColor(Color.rgb(250,62,2));
                    total+=prices[0];
                    int x=total;
                    sum+=Integer.toString(x);
                    //Toast.makeText(breakfast.this, sum, Toast.LENGTH_SHORT).show();
                }
                else{
                    b1.setBackgroundColor(rgb(243,119,149));
                    total-=prices[0];
                    if(total<=0){
                        total=0;
                        sum+="0";
                    }else {
                        int x=total;
                        sum+=Integer.toString(x);
//                        sum += Integer.toString(total);
                    }
                    flg1=0;
//                    Toast.makeText(breakfast.this, sum, Toast.LENGTH_SHORT).show();
                }
                et.setText(sum);
            }
        });
        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                String sum="";

                if(flg2==0) {
                    flg2=1;
                    b2.setBackgroundColor(Color.rgb(250,62,2));
                    total+=prices[1];
                    int x=total;
                    sum+=Integer.toString(x);
                    //Toast.makeText(breakfast.this, sum, Toast.LENGTH_SHORT).show();
                }
                else{
                    b2.setBackgroundColor(rgb(243,119,149));
                    total-=prices[1];
                    if(total<=0){
                        total=0;
                        sum+="0";
                    }else{
                        int x=total;
                    sum+=Integer.toString(x);}
                    flg2=0;
//                    Toast.makeText(breakfast.this, sum, Toast.LENGTH_SHORT).show();
                }
                et.setText(sum);
            }
        });
        b3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                String sum="";

                if(flg3==0) {
                    flg3=1;
                    b3.setBackgroundColor(Color.rgb(250,62,2));
                    total+=prices[2];
                    int x=total;
                    sum+=Integer.toString(x);
                    //Toast.makeText(breakfast.this, sum, Toast.LENGTH_SHORT).show();
                }
                else{
                    b3.setBackgroundColor(rgb(243,119,149));
                    total-=prices[2];
                    if(total<=0){
                        total=0;
                        sum+="0";
                    }else {
                        int x=total;
                        sum+=Integer.toString(x);
                    }
                    flg3=0;
//                    Toast.makeText(breakfast.this, sum, Toast.LENGTH_SHORT).show();
                }
                et.setText(sum);
            }
        });
        b4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                String sum="";
                if(flg4==0) {
                    flg4=1;
                    b4.setBackgroundColor(Color.rgb(250,62,2));
                    total+=prices[3];
                    int x=total;
                    sum+=Integer.toString(x);
                    //Toast.makeText(breakfast.this, sum, Toast.LENGTH_SHORT).show();
                }
                else{
                    b4.setBackgroundColor(rgb(243,119,149));
                    total-=prices[3];
                    if(total<=0){
                        total=0;
                        sum+="0";
                    }else {
                        int x=total;
                        sum+=Integer.toString(x);
                    }
                    flg4=0;
//                    Toast.makeText(breakfast.this, sum, Toast.LENGTH_SHORT).show();
                }
                et.setText(sum);
            }
        });
        b5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                String sum="";

                if(flg5==0) {
                    flg5=1;
                    b5.setBackgroundColor(Color.rgb(250,62,2));
                    total+=prices[4];
                    int x=total;
                    sum+=Integer.toString(x);
                    //Toast.makeText(breakfast.this, sum, Toast.LENGTH_SHORT).show();
                }
                else{
                    b5.setBackgroundColor(rgb(243,119,149));
                    total-=prices[4];
                    if(total<=0){
                        total=0;
                        sum+="0";
                    }else {
                        int x=total;
                        sum+=Integer.toString(x);
                    }
                    flg5=0;
//                    Toast.makeText(breakfast.this, sum, Toast.LENGTH_SHORT).show();
                }
                et.setText(sum);
            }
        });
        b6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                String sum="";

                if(flg6==0) {
                    flg6=1;
                    b6.setBackgroundColor(Color.rgb(250,62,2));
                    total+=prices[5];
                    int x=total;
                    sum+=Integer.toString(x);
                    //Toast.makeText(breakfast.this, sum, Toast.LENGTH_SHORT).show();
                }
                else{
                    b6.setBackgroundColor(rgb(243,119,149));
                    total-=prices[5];
                    if(total<=0){
                        total=0;
                        sum+="0";
                    }else {
                        int x=total;
                        sum+=Integer.toString(x);
                    }
                    flg6=0;
//                    Toast.makeText(breakfast.this, sum, Toast.LENGTH_SHORT).show();
                }
                et.setText(sum);
            }
        });
        b7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                String sum="";

                if(flg7==0) {
                    flg7=1;
                    b7.setBackgroundColor(Color.rgb(250,62,2));
                    total+=prices[6];
                    int x=total;
                    sum+=Integer.toString(x);
                    //Toast.makeText(breakfast.this, sum, Toast.LENGTH_SHORT).show();
                }
                else{
                    b7.setBackgroundColor(rgb(243,119,149));
                    total-=prices[6];
                    if(total<=0){
                        total=0;
                        sum+="0";
                    }else {
                        int x=total;
                        sum+=Integer.toString(x);
                    }
                    flg7=0;
//                    Toast.makeText(breakfast.this, sum, Toast.LENGTH_SHORT).show();
                }
                et.setText(sum);
            }
        });
        b8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                String sum="";

                if(flg8==0) {
                    flg8=1;
                    b8.setBackgroundColor(Color.rgb(250,62,2));
                    total+=prices[7];
                    int x=total;
                    sum+=Integer.toString(x);
                    //Toast.makeText(breakfast.this, sum, Toast.LENGTH_SHORT).show();
                }
                else{
                    b8.setBackgroundColor(rgb(243,119,149));
                    total-=prices[7];
                    if(total<=0){
                        total=0;
                        sum+="0";
                    }else {
                        int x=total;
                        sum+=Integer.toString(x);
                    }
                    flg8=0;
//                    Toast.makeText(breakfast.this, sum, Toast.LENGTH_SHORT).show();
                }
                et.setText(sum);
            }
        });

        proceed.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(total == 0){
                    LayoutInflater inflater=getLayoutInflater(); // to call separate xml file
                    View layout=inflater.inflate(R.layout.custom_toast, (ViewGroup)findViewById(R.id.toast_layout_root));
                    TextView tv=layout.findViewById(R.id.toastTextView);
                    Toast t=new Toast(getApplicationContext());
                    tv.setText("Please select something");

                    Typeface face= Typeface.createFromAsset(getAssets(),"Comfortaa.ttf");
                    tv.setTypeface(face);

                    t.setDuration(Toast.LENGTH_LONG);
                    t.setView(layout);
                    t.show();
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), billing.class);
                    Bundle bun = new Bundle();
                    String s = Integer.toString(total);
                    bun.putString("k1", s);
                    intent.putExtras(bun);
                    startActivity(intent);
                }
            }
        });


        Toolbar toolbar= findViewById(R.id.nav_toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(breakfast.this, drawer,toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
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