package com.example.hp.medicare;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
public class examination extends AppCompatActivity
{
    DatabaseExamination d;
    EditText e1, e2, e3, e4,e5;
    ImageButton b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.examination);
        d = new DatabaseExamination(this);
        e1 = (EditText) findViewById(R.id.date);
        e2 = (EditText) findViewById(R.id.cf);
        e3 = (EditText) findViewById(R.id.pd);
        e4 = (EditText) findViewById(R.id.inv);
        e5 = (EditText) findViewById(R.id.fd);
        b1 = (ImageButton) findViewById(R.id.save);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e2.getText().toString();
                String s4 = e4.getText().toString();
                String s5 = e5.getText().toString();


                if (s1.equals("") || s2.equals("")||s3.equals("")||s4.equals("")||s5.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Boolean insert  = d.insert(s1,s2,s3,s4,s5);
                    if(insert==true)
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
            Intent i=new Intent(examination.this,firstpage.class);
            startActivity(i);
        }

    }

    public void onButton1Click(View v)
    {
        if (v.getId()== R.id.logout)
        {
            Intent i=new Intent(examination.this,MainActivity.class);
            startActivity(i);
        }

    }

    public void onButton5Click(View v)
    {
        if (v.getId()== R.id.save)
        {
            Intent i=new Intent(examination.this,examination.class);
            startActivity(i);
        }

    }



}