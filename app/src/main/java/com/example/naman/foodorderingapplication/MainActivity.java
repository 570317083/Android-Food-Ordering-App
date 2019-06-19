package com.example.naman.foodorderingapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase sqLiteDatabase;
    Button _btn,_btn2;
    EditText _txtn, _txtln, _txtpsw, _txte, _txtno;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.support.v7.app.ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_main);
        openHelper= new DatabaseHelper(this);
        _btn =  (Button)findViewById(R.id.btn);
        _btn2 =  (Button)findViewById(R.id.btnl);
        _txtn = (EditText)findViewById(R.id.txtn);
        _txtln = (EditText)findViewById(R.id.txtln);
        _txtpsw = (EditText)findViewById(R.id.txtpsw);
        _txte = (EditText)findViewById(R.id.txte);
        _txtno = (EditText)findViewById(R.id.txtno);

    _btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            sqLiteDatabase=openHelper.getWritableDatabase();
            String fname= _txtn.getText().toString();
            String lname= _txtln.getText().toString();
            String password= _txtpsw.getText().toString();
            String email= _txte.getText().toString();
            String pno= _txtno.getText().toString();
            insertdata(fname, lname, password, email, pno);
            Intent intent = new Intent(MainActivity.this , login.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "Register Successfully", Toast.LENGTH_LONG).show();

        }
    });
        _btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Welcome",Toast.LENGTH_SHORT).show();
                Intent i;
                i=new Intent(MainActivity.this ,login.class);
                startActivity(i);
                finish();
            }
        });


    }
    public void insertdata(String fname, String lname, String password, String email, String pno)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put (DatabaseHelper.COL_2, fname);
        contentValues.put (DatabaseHelper.COL_3, lname);
        contentValues.put (DatabaseHelper.COL_4, password);
        contentValues.put (DatabaseHelper.COL_5, email);
        contentValues.put (DatabaseHelper.COL_6, pno);
        long id = sqLiteDatabase.insert(DatabaseHelper.TABLE_NAME, null, contentValues);


    }
}
