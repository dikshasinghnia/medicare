package com.example.hp.medicare;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
public class viewpatient extends AppCompatActivity
{    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpatient);

    }
    public void onButtonClick(View v)
    {
        if (v.getId()== R.id.Details)
        {
            Intent i=new Intent(viewpatient.this,viewdetails.class);
            startActivity(i);
        }
    }
    public void onButton1Click(View v)
    {
        if (v.getId()== R.id.history)
        {
            Intent i=new Intent(viewpatient.this,viewhistory.class);
            startActivity(i);
        }
    }
    public void onButton2Click(View v)
    {
        if (v.getId()== R.id.prescription)
        {
            Intent i=new Intent(viewpatient.this,viewp.class);
            startActivity(i);
        }
    }
    public void onButton3Click(View v)
    {
        if (v.getId()== R.id.examination)
        {
            Intent i=new Intent(viewpatient.this,viewe.class);
            startActivity(i);
        }
    }
    public void onButton4Click(View v)
    {
        if (v.getId()== R.id.logout)
        {
            Intent i=new Intent(viewpatient.this,MainActivity.class);
            startActivity(i);
        }
    }
    public void onButton5Click(View v)
    {
        if (v.getId()== R.id.appointment)
        {
            Intent i=new Intent(viewpatient.this,addappointment.class);
            startActivity(i);
        }
    }
    public void onButton6Click(View v)
    {
        if (v.getId()== R.id.home)
        {
            Intent i=new Intent(viewpatient.this,firstpage.class);
            startActivity(i);
        }
    }
}