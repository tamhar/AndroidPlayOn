package com.example.arrizky.kabaddi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Menu extends AppCompatActivity {

    ImageButton kabaddi, video, bantuan, info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        kabaddi = (ImageButton) findViewById(R.id.Bkabaddi);
        video = (ImageButton) findViewById(R.id.Bvideo);
        bantuan = (ImageButton) findViewById(R.id.Bbantuan);
        info = (ImageButton) findViewById(R.id.Binfo);
        kabaddiClick();
        videoClick();
        bantuanClick();
        infoClick();
    }

    private void kabaddiClick(){
        kabaddi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this,kabaddi.class);
                startActivity(i);
            }
        });
    }

    private void videoClick(){
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this,video.class);
                startActivity(i);
            }
        });
    }

    private void bantuanClick(){
        bantuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this,bantuan.class);
                startActivity(i);
            }
        });
    }

    private void infoClick(){
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this,info.class);
                startActivity(i);
            }
        });
    }
}
