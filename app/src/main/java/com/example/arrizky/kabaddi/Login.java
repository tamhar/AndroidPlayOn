package com.example.arrizky.kabaddi;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.constraint.solver.widgets.Helper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.arrizky.kabaddi.Helper.DatabaseHandler;
import com.example.arrizky.kabaddi.Helper.User;

public class Login extends AppCompatActivity {

    Button login, daftar;
    EditText uname, pass;
    DatabaseHandler dbhelper;
    User user;
    private ProgressDialog prog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        uname = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.pass);
        login = (Button) findViewById(R.id.signin);
        daftar = (Button) findViewById(R.id.signup);
        dbhelper = new DatabaseHandler(Login.this);
        user = new User();
        toLogin();
        toDaftar();
    }

    void toLogin(){
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.setUsername(uname.getText().toString().trim());
                user.setPassword(pass.getText().toString().trim());
                if(dbhelper.checkUser(user)){
                    Intent i = new Intent(Login.this,Menu.class);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(Login.this, "Username / Password Salah", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    void toDaftar(){
        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this,Daftar.class);
                startActivity(i);
                finish();
            }
        });
    }
}
