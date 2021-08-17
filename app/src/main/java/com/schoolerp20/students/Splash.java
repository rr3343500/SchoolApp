package com.schoolerp20.students;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.schoolerp20.students.modal.User;


public class Splash extends AppCompatActivity {
    User user;
    private NotificationManager mNotificationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_splash );
        user=new User( Splash.this );
        new Handler().postDelayed( new Runnable() {
            @Override
            public void run() {
                if (user.getUserid().isEmpty()){
                    startActivity( new Intent( Splash.this,Login.class ) );
                    finish();
                }else {
                    startActivity( new Intent( Splash.this,MainActivity.class ) );
                    finish();
                }

            }
        }, 2000);
    }
}
