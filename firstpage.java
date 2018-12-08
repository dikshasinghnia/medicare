package com.example.hp.medicare;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class firstpage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstpage);
    }
    public void onButton1Click(View v)
    {
        if (v.getId()== R.id.addpatient)
        {
            Intent i=new Intent(firstpage.this,addpatient.class);
            startActivity(i);
        }

    }
    public void onButton2Click(View v)
    {
        if (v.getId()== R.id.viewpatient)
        {
            Intent i=new Intent(firstpage.this,viewpatient.class);
            startActivity(i);
        }

    }
    public void onButtonClick(View v)
    {
        if (v.getId()== R.id.logout)
        {
            Intent i=new Intent(firstpage.this,MainActivity.class);
            startActivity(i);
        }

    }
    public void onButton4Click(View v)
    {
        if (v.getId()== R.id.addevent)
        {
            Intent i=new Intent(firstpage.this,addappointment.class);
            startActivity(i);
        }

    }
    public void onButton5Click(View v)
    {
        if (v.getId()== R.id.showevent)
        {
            Intent i=new Intent(firstpage.this,viewappointment.class);
            startActivity(i);
        }

    }



}

