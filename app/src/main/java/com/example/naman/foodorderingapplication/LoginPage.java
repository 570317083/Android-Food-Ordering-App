package com.example.naman.foodorderingapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginPage extends AppCompatActivity {
    Button loginbtn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        actionBar.hide();  /////code to hide title bar

        setContentView(R.layout.activity_login_page);
        loginbtn = (Button) findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name =(EditText) findViewById(R.id.name_edittext);
                EditText phone =(EditText) findViewById(R.id.phone_edittext);
                EditText adr =(EditText) findViewById(R.id.adr_edittext);
                use.nm=name.getText().toString();
                use.ad=adr.getText().toString();
                use.ph=phone.getText().toString();
                if( use.nm.isEmpty() )
                    name.setError("Enter Your Name!!!");
                else if(use.ph.isEmpty())
                    phone.setError("Enter Your Number!!!");
                else if(use.ph.isEmpty())
                    adr.setError("Enter Your Address!!!");
                else {
                    Intent intent = new Intent(LoginPage.this, HomeActivity.class);
                    startActivity(intent);
                    Toast.makeText(LoginPage.this,"welcome",Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}
