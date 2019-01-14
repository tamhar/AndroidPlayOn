package com.example.arrizky.kabaddi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import com.example.arrizky.kabaddi.Helper.ProgressAnim;

import java.util.Map;

public class Splash extends AppCompatActivity {
    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        progress = (ProgressBar) findViewById(R.id.progress);

        Thread timer = new Thread() {
            public void run() {
                try {
                    ProgressAnim anim = new ProgressAnim(progress, 10, 100);
                    anim.setDuration(1000);
                    progress.startAnimation(anim);
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    try{
                        Intent i = new Intent(Splash.this,Login.class);
                        startActivity(i);
                        finish();
                    }catch (NullPointerException e) {
                        Intent i = new Intent(Splash.this,Login.class);
                        startActivity(i);
                        finish();
                    }
                }
            }
        };
        timer.start();
    }
}
