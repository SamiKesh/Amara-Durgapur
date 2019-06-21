package com.nnk.DurgapurTourism;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    private int SLEEP_TIMER=3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splashscreen);
        getSupportActionBar().hide();
        ImageView imageView =findViewById(R.id.i1);
        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        imageView.startAnimation(animation);
        TextView textView= findViewById(R.id.t1);
        textView.startAnimation(animation);
        LogoLauncher logoLauncher=new LogoLauncher();
        logoLauncher.start();
    }
    private class LogoLauncher extends Thread {
        public void run() {
            try {
                sleep(3500 * SLEEP_TIMER);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           // Intent intent1 = new Intent(SplashScreen.this, MainActivity.class);
           // startActivity(intent1);
            //SplashScreen.this.finish();

            if(load())
            {
                Intent intent = new Intent(SplashScreen.this, LoginPage.class);
                startActivity(intent);
                SplashScreen.this.finish();
            }
            else
            {
                Intent intent = new Intent(SplashScreen.this, MaintwoActivity.class);
                startActivity(intent);
                SplashScreen.this.finish();
            }

        }
    }

    private boolean load() {

        SharedPreferences sharedPreferences = getSharedPreferences("userData1", Context.MODE_PRIVATE);
        String email = sharedPreferences.getString("user_email","");
        String password = sharedPreferences.getString("user_password","");
        if(email.equals("") || password.equals(""))
        {
            return true;
        }
        else
            return false;

    }
}
