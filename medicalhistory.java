package com.example.hp.medicare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class medicalhistory extends AppCompatActivity

{
    DatabaseHistory d;
    EditText e1, e2, e3, e4;
    ImageButton b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicalhistory);
        d = new DatabaseHistory(this);
        e1 = (EditText) findViewById(R.id.date);
        e2 = (EditText) findViewById(R.id.medical_history);
        e3 = (EditText) findViewById(R.id.notes);
        e4 = (EditText) findViewById(R.id.ccomplaint);
        b1 = (ImageButton) findViewById(R.id.save);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e2.getText().toString();
                String s2 = e3.getText().toString();
                String s3 = e4.getText().toString();
                String s7 = e1.getText().toString();
                if (s3.equals("") || s7.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else
                    {
                    Boolean add = d.insert(s7, s1, s2, s3);
                    if (add == true)
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


    public void onButtonClick(View v) {
        if (v.getId() == R.id.prescription) {
            Intent i = new Intent(medicalhistory.this, prescription.class);
            startActivity(i);
        }
    }

    public void onButton2Click(View v) {
        if (v.getId() == R.id.home) {
            Intent i = new Intent(medicalhistory.this, firstpage.class);
            startActivity(i);
        }

    }

    public void onButton3Click(View v) {
        if (v.getId() == R.id.logout) {
            Intent i = new Intent(medicalhistory.this, MainActivity.class);
            startActivity(i);
        }

    }
    public void onButton1Click(View v) {
        if (v.getId() == R.id.logout) {
            Intent i = new Intent(medicalhistory.this, addappointment.class);
            startActivity(i);
        }

    }

}