package com.example.foodparadise;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.app.RemoteInput;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class billing extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener  {
    private DrawerLayout drawer;
    String bill="";
    TextView tv;
    Button b;

    NotificationManager nm;
    static final String channel_id="My Channel";
    static final int noti_id=1;
    static final String my_key="Remote Input Key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billing);


        FontChangeCrawler fontChanger = new FontChangeCrawler(getAssets(), "Comfortaattf");
        fontChanger.replaceFonts((ViewGroup)this.findViewById(android.R.id.content));

        tv=findViewById(R.id.ed);
        b=findViewById(R.id.btn);
        Bundle bun=getIntent().getExtras();
        if(bun!=null){
            String s=bun.getString("k1");
            bill=s;
            tv.setText(bill);
        }

        Toolbar toolbar= findViewById(R.id.nav_toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(billing.this, drawer,toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);

    }

    public void place(View view) {
        AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(billing.this);
        builder.setMessage("Proceed to order your meal")
                .setCancelable(false)

                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(bill!="0") {
                            myChannel();
                            Intent i=new Intent(billing.this,notification2.class);
                            PendingIntent pi=PendingIntent.getActivity(billing.this,
                                    1,i,PendingIntent.FLAG_ONE_SHOT);
                            NotificationCompat.Builder builder=new NotificationCompat.Builder
                                    (billing.this,channel_id);
                            builder.setSmallIcon(R.drawable.alert);
                            builder.setContentTitle("Food Paradise");
                            builder.setContentText("Your order is placed successfully");
                            builder.setContentIntent(pi);
                            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
                            {
                                RemoteInput ri=new RemoteInput.Builder(my_key).setLabel("Replying..")
                                        .build();
                                NotificationCompat.Action action=new NotificationCompat.Action.Builder
                                        (R.drawable.alert,"reply",pi).addRemoteInput(ri).build();
                                builder.addAction(action);
                            }
                            builder.setAutoCancel(true);
                            nm.notify(noti_id,builder.build());

                            Intent it=new Intent(getApplicationContext(), Rating.class);
                            startActivity(it);
                            //finish();
                        }
                        else{
                            LayoutInflater inflater=getLayoutInflater(); // to call separate xml file
                            View layout=inflater.inflate(R.layout.custom_toast, (ViewGroup)findViewById(R.id.toast_layout_root));
                            TextView tv=layout.findViewById(R.id.toastTextView);
                            Toast t=new Toast(getApplicationContext());
                            tv.setText("Kindly select something");

                            Typeface face= Typeface.createFromAsset(getAssets(),"Comfortaa.ttf");
                            tv.setTypeface(face);

                            t.setDuration(Toast.LENGTH_LONG);
                            t.setView(layout);
                            t.show();
                        }

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        //Creating dialog box
        AlertDialog dialog  = builder.create();
        dialog.show();
        TextView textView = (TextView) dialog.findViewById(android.R.id.message);
        Typeface face= Typeface.createFromAsset(getAssets(),"Comfortaa.ttf");
        textView.setTypeface(face);

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

    @RequiresApi(api = Build.VERSION_CODES.O)
    void myChannel()
    {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.N)
        {
            String name="my channel ";
            String des="My channel Desription";
            int imp= NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel nc=new NotificationChannel(channel_id,name,imp);
            nc.setDescription(des);
            nm.createNotificationChannel(nc);

        }
    }
}
  /** Improve some things ***
   font style of navigation items, font style of toolbar ***/