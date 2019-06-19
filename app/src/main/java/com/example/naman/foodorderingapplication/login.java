package com.example.naman.foodorderingapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    SQLiteDatabase sqLiteDatabase;
    SQLiteOpenHelper openHelper;
    Button _btnl ,_btn2;
    EditText _txt1, _txt2;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.support.v7.app.ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_login);
        openHelper = new DatabaseHelper(this);
        sqLiteDatabase=openHelper.getReadableDatabase();
        _btnl=(Button)findViewById(R.id.btnl);
        _btn2 =(Button)findViewById(R.id.btn2);
        _txt1=(EditText)findViewById(R.id.txt1);
        _txt2=(EditText)findViewById(R.id.txt2);


        _btnl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = _txt1.getText().toString();
                String password = _txt2.getText().toString();
                cursor = sqLiteDatabase.rawQuery("SELECT * FROM " +DatabaseHelper.TABLE_NAME+ " WHERE " + DatabaseHelper.COL_5+ " =? AND " + DatabaseHelper.COL_4+ "=?", new String[]{email, password});
                if (cursor.getCount()>0)
                {
                    Intent intent = new Intent(login.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(getApplicationContext(),"LOGIN SUCCESSFULL", Toast.LENGTH_LONG).show();
                    Toast.makeText(login.this,"Welcome",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Incorrect Credentials", Toast.LENGTH_LONG).show();
                }
            }
        });
        _btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(login.this,"Welcome",Toast.LENGTH_SHORT).show();
                Intent i;
                i=new Intent(login.this ,MainActivity.class);
                startActivity(i);
                finish();
            }
        });



    }
}
