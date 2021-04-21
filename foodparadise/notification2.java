package com.example.foodparadise;

import android.app.NotificationManager;
import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class notification2 extends AppCompatActivity {
    TextView tv;
    NotificationManager nm;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification2);
        tv=findViewById(R.id.tv);



        Bundle b= RemoteInput.getResultsFromIntent(getIntent());
        if(b!=null)
        {
            tv.setText(b.getString(billing.my_key));
        }
        nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        nm.cancel(billing.noti_id);
    }
}