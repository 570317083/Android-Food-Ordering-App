package com.example.naman.foodorderingapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class mochacafe extends AppCompatActivity {

    boolean coffee=false;

    boolean icecream=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        actionBar.hide();  /////code to hide title bar

        setContentView(R.layout.activity_buddyscafe);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        CheckBox Coffee=(CheckBox)findViewById(R.id.coffee_checkbox);
        coffee= Coffee.isChecked();

        CheckBox Icecream=(CheckBox)findViewById(R.id.icecream_checkbox);
        icecream=Icecream.isChecked();

        EditText namefield=(EditText)findViewById(R.id.name_edittext);
        String name=namefield.getText().toString();

        int price=calculatePrice(coffee,icecream);
        createOrderSummary(name,price,coffee,icecream);


    }

    /*creates order sumary.
    *
    * @param price of order.
    * @return the order summary
     */
    public void createOrderSummary(String name,int price,boolean coffee,boolean icecream)
    {
        CheckBox Coffee=(CheckBox)findViewById(R.id.coffee_checkbox);
        coffee=Coffee.isChecked();
        String summary="\nOrder is:";
        if(coffee)
            summary += "\nCold Coffee";
        if(icecream)
            summary +="\nIcecream";
        summary+="\nPrice : Rs"+ price;
        summary+="\nThank You!";
        String subject="Customer Name : "+name;
        Intent intent=new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));//Specifies that only email apps can handle this
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);//creates subject
        intent.putExtra(Intent.EXTRA_TEXT,summary);//creates emailbody
        if(intent.resolveActivity(getPackageManager())!=null){      //checks whether activity is available to handl this or not
            startActivity(intent);
        }
    }

    private int calculatePrice(boolean coffee,boolean icecream) {
        int price=0;
        if(icecream){
            price=price+50;
        }
        if(coffee){
            price=price+70;
        }
        return price;
    }

}

