package com.example.hp.medicare;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
public class addappointment extends AppCompatActivity {
    DatabaseAppointment d;
    EditText e1,e2,e3,e4;
    ImageButton b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addappointment);
        d = new DatabaseAppointment(this);
        e1 = (EditText) findViewById(R.id.opd);
        e2 = (EditText) findViewById(R.id.name);
        e3 = (EditText) findViewById(R.id.date);
        e4 = (EditText) findViewById(R.id.time);
        b1 = (ImageButton) findViewById(R.id.save);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                String s4 = e4.getText().toString();
                String s1=e1.getText().toString();
                if (s1.equals("") || s3.equals("") || s4.equals("") || s2.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Boolean insert = d.insert(s1, s2, s3, s4);
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
            Intent i=new Intent(addappointment.this,firstpage.class);
            startActivity(i);
        }

    }
    public void onButton3Click(View v)
    {
        if (v.getId()== R.id.logout)
        {
            Intent i=new Intent(addappointment.this,MainActivity.class);
            startActivity(i);
        }

    }
    public void onButton1Click(View v)
    {
        if (v.getId()== R.id.addpatient)
        {
            Intent i=new Intent(addappointment.this,addpatient.class);
            startActivity(i);
        }

    }
}