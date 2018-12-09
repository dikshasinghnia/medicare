package com.example.hp.medicare;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class prescription extends AppCompatActivity
{

        DatabaseP d;
        EditText e1, e2, e3, e4,e5,e6,e7,e8;
        ImageButton b1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prescription);
        d = new DatabaseP(this);
        e1 = (EditText) findViewById(R.id.name);
        e2 = (EditText) findViewById(R.id.date);
        e3 = (EditText) findViewById(R.id.date);
        e4 = (EditText) findViewById(R.id.age);
        e5 = (EditText) findViewById(R.id.ccomplaint);
        e6 = (EditText) findViewById(R.id.medicine);
        e7 = (EditText) findViewById(R.id.tests);
        e8 = (EditText) findViewById(R.id.doc);
        b1 = (ImageButton) findViewById(R.id.save);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e2.getText().toString();
                String s4 = e4.getText().toString();
                String s5 = e5.getText().toString();
                String s6 = e6.getText().toString();
                String s7 = e7.getText().toString();
                String s8 = e8.getText().toString();

                if (s1.equals("") || s2.equals("")||s3.equals("")||s4.equals("")||s5.equals("")||s6.equals("")||s8.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Boolean insert  = d.insert(s1,s2,s3,s4,s5,s6,s7,s8);
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

    public void onButtonClick(View v)
    {
        if (v.getId()== R.id.home)
        {
            Intent i=new Intent(prescription.this,firstpage.class);
            startActivity(i);
        }

    }

    public void onButton2Click(View v)
    {
        if (v.getId()== R.id.logout)
        {
            Intent i=new Intent(prescription.this,MainActivity.class);
            startActivity(i);
        }

    }

    public void onButton5Click(View v)
    {
        if (v.getId()== R.id.exam)
        {
            Intent i=new Intent(prescription.this,examination.class);
            startActivity(i);
        }

    }
    public void onButton1Click(View v)
    {
        if (v.getId()== R.id.exam)
        {
            Intent i=new Intent(prescription.this,addappointment.class);
            startActivity(i);
        }

    }


}