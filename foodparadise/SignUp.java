package com.example.foodparadise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class SignUp extends AppCompatActivity {

    EditText emailaddd, password, name, ph;
    Button sign;
    SharedPreferences sp;
    public static final String sharedprefilename="myfile";
    public static final String Email="myemailkey";
    public static final String Pwd="mypasswordkey";
    public static final String Name="mynamekey";
    public static final String Phone="myphonekey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        FontChangeCrawler fontChanger = new FontChangeCrawler(getAssets(), "Comfortaa.ttf");
        fontChanger.replaceFonts((ViewGroup)this.findViewById(android.R.id.content));

        emailaddd=findViewById(R.id.uid);
        password=findViewById(R.id.password);
        name=findViewById(R.id.nid);
        ph=findViewById(R.id.phone);

        sp=getSharedPreferences(sharedprefilename, Context.MODE_PRIVATE);
        Toolbar toolbar= findViewById(R.id.nav_toolbar);
        setSupportActionBar(toolbar);

        password.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(i==R.id.login  || i== EditorInfo.IME_NULL){
                    calAttemptLogin();
                    return true;
                }
                return false;
            }
        });
        sign=findViewById(R.id.signup);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calAttemptLogin();
            }
        });


    }

    private void calAttemptLogin() {
        emailaddd.setError(null);
        password.setError(null);
        name.setError(null);
        ph.setError(null);
        String email=emailaddd.getText().toString();
        String pass=password.getText().toString();
        String Nam=name.getText().toString();
        String phoneno=ph.getText().toString();
        boolean cancel=false;
        View focusview=null;
        if(TextUtils.isEmpty(pass) || !isPasswordValid(pass)){
            password.setError("Invalid Password");
            focusview=password;
            cancel = true;
        }
        if(TextUtils.isEmpty(pass) || !isEmailValid(email)){
            emailaddd.setError("Invalid Email");
            focusview=emailaddd;
            cancel = true;
        }
        if(TextUtils.isEmpty(Nam) || !isNameValid(Nam)){
            name.setError("Invalid Name");
            focusview=name;
            cancel = true;
        }
        if(TextUtils.isEmpty(phoneno) || !isPhoneValid(phoneno)){
            ph.setError("Invalid Phone Number");
            focusview=ph;
            cancel = true;
        }
        if(cancel){
            focusview.requestFocus();
        }
        else {

            SharedPreferences.Editor ed=sp.edit();
            ed.putString(Email,email);
            ed.putString(Pwd, pass);
            ed.putString(Name,Nam);
            ed.putString(Phone, phoneno);
            ed.commit();
            Intent i = new Intent(SignUp.this, perference.class);
            startActivity(i);
            finish();

        }
    }

    public boolean number(String p){
        for(int i=0;i<p.length();i++){
            if(p.charAt(i)<'0' || p.charAt(i)>'9') return false;
        }
        return true;
    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPasswordValid(String pass) {
        return pass.length()>=5;
    }

    private boolean isNameValid(String name){ return name.length()>=3;}

    private boolean isPhoneValid(String phone){ return (phone.length()==10 && number(phone));}
}

/** Improve some things ***
 Proper Validations should be there ***/