package com.example.naman.foodorderingapplication;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ccd extends AppCompatActivity {

    boolean coffee=false;
    boolean icecream=false;
    int pr=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        actionBar.hide();  /////code to hide title bar


        setContentView(R.layout.activity_buddyscafe);
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.coffee_checkbox:
                if (checked) {
                    Button a=(Button) findViewById(R.id.cbuttoninc);
                    a.setEnabled(true);
                    Button b=(Button) findViewById(R.id.cbuttondec);
                    b.setEnabled(true);
                }
                else {
                    Button a = (Button) findViewById(R.id.cbuttoninc);
                    a.setEnabled(false);
                    Button b = (Button) findViewById(R.id.cbuttondec);
                    b.setEnabled(false);
                    TextView quantityTextView = (TextView) findViewById(R.id.cquantity_text_view);
                    quantityTextView.setText("0");
                }
                break;
            case R.id.icecream_checkbox:
                if (checked) {
                    Button a = (Button) findViewById(R.id.ibuttoninc);
                    a.setEnabled(true);
                    Button b = (Button) findViewById(R.id.ibuttondec);
                    b.setEnabled(true);
                }
                else {
                    Button a = (Button) findViewById(R.id.ibuttoninc);
                    a.setEnabled(false);
                    Button b = (Button) findViewById(R.id.ibuttondec);
                    b.setEnabled(false);
                    TextView quantityTextView = (TextView) findViewById(R.id.iquantity_text_view);
                    quantityTextView.setText("0");
                }
                break;
        }
    }

    public void cincrement(View view) {
        int duration=Toast.LENGTH_SHORT;
        TextView q = (TextView) findViewById(R.id.cquantity_text_view);
        int  qty=Integer.parseInt(q.getText().toString());
        TextView p = (TextView) findViewById(R.id.coffee_price);
        int  pri=Integer.parseInt(p.getText().toString());
        Context context=getApplicationContext();
        if(qty==10){
            Toast.makeText(context,"You cannot order more than 10 coffees.",duration).show();
            //display(10);
            return;
        }
        qty=qty+1;
        q.setText("" + qty);
        TextView coffeetotal= (TextView) findViewById(R.id.ctotal);
        coffeetotal.setText((String.valueOf(qty*pri)));
        display();
    }
    public void cdecrement(View view) {
        int duration=Toast.LENGTH_SHORT;
        TextView q = (TextView) findViewById(R.id.cquantity_text_view);
        int  qty=Integer.parseInt(q.getText().toString());
        TextView p = (TextView) findViewById(R.id.coffee_price);
        int  pri=Integer.parseInt(p.getText().toString());
        if(qty==0){
            Toast.makeText(this,"You cannot order less than 1 coffee.",duration).show();
            //display(0);
            return;
        }
        qty=qty-1;
        q.setText(""+ (String.valueOf(qty)));
        TextView coffeetotal= (TextView) findViewById(R.id.ctotal);
        coffeetotal.setText((String.valueOf(qty*pri)));
        display();
    }

    public void iincrement(View view) {
        int duration=Toast.LENGTH_SHORT;
        TextView q = (TextView) findViewById(R.id.iquantity_text_view);
        int  qty=Integer.parseInt(q.getText().toString());
        TextView p = (TextView) findViewById(R.id.icecream_price);
        int  pri=Integer.parseInt(p.getText().toString());
        Context context=getApplicationContext();
        if(qty==10){
            Toast.makeText(context,"You cannot order more than 10 coffees.",duration).show();
            //display(10);
            return;
        }
        qty=qty+1;
        q.setText("" + qty);
        TextView icecreamtotal= (TextView) findViewById(R.id.itotal);
        icecreamtotal.setText((String.valueOf(qty*pri)));
        display();
    }
    public void idecrement(View view) {
        int duration=Toast.LENGTH_SHORT;
        TextView q = (TextView) findViewById(R.id.iquantity_text_view);
        int  qty=Integer.parseInt(q.getText().toString());
        TextView p = (TextView) findViewById(R.id.icecream_price);
        int  pri=Integer.parseInt(p.getText().toString());
        if(qty==0){
            Toast.makeText(this,"You cannot order less than 1 Icecream.",duration).show();
            //display(0);
            return;
        }
        qty=qty-1;
        q.setText(""+ (String.valueOf(qty)));
        TextView icecreamtotal= (TextView) findViewById(R.id.itotal);
        icecreamtotal.setText((String.valueOf(qty*pri)));
        display();
    }


    /**
     * This method displays the given quantity value on the screen.
     */

    private void display() {
        TextView c = (TextView) findViewById(R.id.ctotal);
        TextView i = (TextView) findViewById(R.id.itotal);
        int a=Integer.parseInt(c.getText().toString());
        int b=Integer.parseInt(i.getText().toString());
        TextView total = (TextView) findViewById(R.id.total);
        total.setText("" + (String.valueOf(a+b)));
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


        createOrderSummary(pr,coffee,icecream);


    }

    /*creates order sumary.
    *
    * @param price of order.
    * @return the order summary
     */
    public void createOrderSummary(int price,boolean coffee,boolean icecream)
    {
        CheckBox Coffee=(CheckBox)findViewById(R.id.coffee_checkbox);
        coffee=Coffee.isChecked();
        String summary="Contact Number:"+use.ph+"\nOrder is:";
        if(coffee)
            summary += "\n Cold Coffee";
        if(icecream)
            summary +="\n Icecream";
        summary+="\nPrice : Rs"+ price;
        summary+="\n\nDeliver At Address:\n"+ use.ad;
        summary+="\nThank You! "+use.nm;
        String subject="Customer Name : "+use.nm;
        Intent intent=new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:maheshwari1998.15@gmail.com"));//Specifies that only email apps can handle this
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);//creates subject
        intent.putExtra(Intent.EXTRA_TEXT,summary);//creates emailbody
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//Check user return to app insted of email app


        try{
            startActivity(intent);
            finish();

        }catch(ActivityNotFoundException ex){
            Toast.makeText(this, "Email App Not Installed.", Toast.LENGTH_SHORT).show();
        }
    }


}