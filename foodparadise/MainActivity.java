package com.example.foodparadise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Application;
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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText emailaddd, password;
    Button login;
    CheckBox cb;
    SharedPreferences sp;
    public static final String sharedprefilename="myfile";
    public static final String Email="myemailkey";
    public static final String Pwd="mypasswordkey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FontChangeCrawler fontChanger = new FontChangeCrawler(getAssets(), "Comfortaa.ttf");
        fontChanger.replaceFonts((ViewGroup)this.findViewById(android.R.id.content));

        emailaddd=findViewById(R.id.uid);
        password=findViewById(R.id.password);
      //  cb=findViewById(R.id.checkBoxRememberMe);
        sp=getSharedPreferences(sharedprefilename, Context.MODE_PRIVATE);
        Toolbar toolbar= findViewById(R.id.nav_toolbar);
        setSupportActionBar(toolbar);


        if(sp.contains(Email)){
            emailaddd.setText(sp.getString(Email,""));
        }
        if(sp.contains(Pwd)){
            password.setText(sp.getString(Pwd,""));
        }

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
        login=findViewById(R.id.loginbtn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calAttemptLogin();
            }
        });


    }

    private void calAttemptLogin() {
        emailaddd.setError(null);
        password.setError(null);
        String email=emailaddd.getText().toString();
        String pass=password.getText().toString();


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



        if(cancel){
            focusview.requestFocus();
        }
        else {

            if(!sp.contains(Email) || (sp.contains(Email) && !email.equals(sp.getString(Email, "")))) {
                Toast.makeText(this, "Invalid Email and Password", Toast.LENGTH_SHORT).show();
            }

            else if( !sp.contains(Pwd) ||(sp.contains(Pwd) && !pass.equals(sp.getString(Pwd, "")))) {
                Toast.makeText(this, "Invalid Email and Password", Toast.LENGTH_SHORT).show();
            }

            else {
               // save();
                Intent i = new Intent(MainActivity.this, perference.class);
                startActivity(i);
                finish();
            }

        }
    }

    public void save(){
        emailaddd.setError(null);
        password.setError(null);
        String email=emailaddd.getText().toString();
        String pass=password.getText().toString();
        SharedPreferences.Editor ed=sp.edit();
        ed.putString(Email,email);
        ed.putString(Pwd, pass);
        ed.commit();
    }
//
//    public void clear(View v){
//
//        emailaddd.setText("");
//        password.setText("");
//        SharedPreferences.Editor editor = sp.edit();
//        editor.clear();
//        editor.apply();
//
//
//    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPasswordValid(String pass) {
        return pass.length()>=5;
    }

    public void signUp(View view) {
        Intent i=new Intent(getApplicationContext(),SignUp.class);
        startActivity(i);
    }
}

/** Improve some things ***
 Proper validations and Forget Password and Remeber Me should work properly ***/

/*
<CheckBox
            android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:text="Remember Me"
                    android:layout_marginTop="10dp"
                    android:layout_marginLeft="30dp"
                    android:id="@+id/checkBoxRememberMe"/>
<Button
            android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_marginTop="25dp"
                    android:layout_marginRight="5dp"
                    android:layout_marginLeft="180dp"
                    android:padding="10dp"
                    android:textColor="#FF3D00"
                    style="?android:attr/borderlessButtonStyle"
                    android:text="Forget Password?"
                    android:textStyle="bold"
                    android:id="@+id/reset"
                    android:onClick="clear"
                    />
*/
