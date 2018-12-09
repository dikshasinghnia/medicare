package com.example.hp.medicare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class addpatient extends AppCompatActivity {
    DatabasePatient d;
    EditText e1,e2,e3,e4,e5,e6,e7;
    ImageButton b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addpatient);
        d = new DatabasePatient(this);
        e1 = (EditText) findViewById(R.id.date);
        e2 = (EditText) findViewById(R.id.name);
        e3 = (EditText) findViewById(R.id.age);
        e4 = (EditText) findViewById(R.id.sex);
        e5 = (EditText) findViewById(R.id.address);
        e6 = (EditText) findViewById(R.id.email);
        e7 = (EditText) findViewById(R.id.mobile);
        b1 = (ImageButton) findViewById(R.id.save);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e2.getText().toString();
                String s2 = e3.getText().toString();
                String s3 = e4.getText().toString();
                String s4 = e5.getText().toString();
                String s5 = e6.getText().toString();
                String s6 =e7.getText().toString();
                String s7=e1.getText().toString();
                if (s1.equals("") || s3.equals("") || s4.equals("") || s5.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else
                {
                 Boolean insert = d.insert(s7,s1, s2, s3, s4, s5, s6);
                 if (insert == true)
                 {
                     Toast.makeText(getApplicationContext(), "sucessfully saved", Toast.LENGTH_SHORT).show();
                 }
                 else
                  {
                      Toast.makeText(getApplicationContext(), "Could not be saved ", Toast.LENGTH_SHORT).show();
                  }
                }

            }
        });
    }
    public void onButton2Click(View v)
    {
        if (v.getId()== R.id.home)
        {
            Intent i=new Intent(addpatient.this,firstpage.class);
            startActivity(i);
        }

    }
    public void onButton3Click(View v)
    {
        if (v.getId()== R.id.logout)
        {
            Intent i=new Intent(addpatient.this,MainActivity.class);
            startActivity(i);
        }

    }
    public void onButton1Click(View v)
    {
        if (v.getId()== R.id.mh)
        {
            Intent i=new Intent(addpatient.this,medicalhistory.class);
            startActivity(i);
        }

    }




}