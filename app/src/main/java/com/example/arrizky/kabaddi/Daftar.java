package com.example.arrizky.kabaddi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.arrizky.kabaddi.Helper.DatabaseHandler;
import com.example.arrizky.kabaddi.Helper.User;

public class Daftar extends AppCompatActivity {

    Button daftar;
    EditText uname, pass;
    DatabaseHandler dbhelper;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        uname = (EditText) findViewById(R.id.duser);
        pass = (EditText) findViewById(R.id.dpass);
        daftar = (Button) findViewById(R.id.dsignup);
        dbhelper = new DatabaseHandler(Daftar.this);
        user = new User();
        todaftar();
    }

    void todaftar(){
        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setUsername(uname.getText().toString().trim());
                user.setPassword(pass.getText().toString().trim());
                dbhelper.addUser(user);
                Intent i = new Intent(Daftar.this,Login.class);
                startActivity(i);
                finish();
            }
        });
    }
}
