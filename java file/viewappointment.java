package com.example.hp.medicare;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class viewappointment extends AppCompatActivity
{

        EditText dt;
        DatabaseAppointment mydb;
        Button btnview;
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.viewappointment);
            dt=(EditText)findViewById(R.id.date);
            mydb=new DatabaseAppointment(this);
            viewallappointment();

        }
        public void displayappointment(String title,String content)
        {   AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setTitle(title);
            builder.setMessage(content);
            builder.show();
        }
        public  void viewallappointment()
        {
            dt=(EditText)findViewById(R.id.date);
            btnview=(Button)findViewById(R.id.find);
            btnview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String dte=dt.getText().toString();
                    Cursor result=mydb.getappo(dte);
                    if (dte.equals(""))
                    {
                        Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                    }
                    else if (result.getCount()==0)
                    {
                        displayappointment("Error","NO records");
                    }
                    else
                    {
                        StringBuffer Buffer=new StringBuffer();
                        while (result.moveToNext())
                        {
                        Buffer.append("OPD NO: "+result.getString(0)+"\n");
                        Buffer.append("NAME: "+result.getString(1)+"\n");
                        Buffer.append("DATE: "+result.getString(2)+"\n");
                        Buffer.append("TIME: "+result.getString(3)+"\n");
                        }
                        displayappointment("Patient List",Buffer.toString());

                    }
                }
            });
        }

    public void onButtonClick(View v)
    {
        if (v.getId()== R.id.home)
        {
            Intent i=new Intent(viewappointment.this,firstpage.class);
            startActivity(i);
        }

    }
    public void onButton2Click(View v)
    {
        if (v.getId()== R.id.logout)
        {
            Intent i=new Intent(viewappointment.this,MainActivity.class);
            startActivity(i);
        }

    }
    public void onButton1Click(View v)
    {
        if (v.getId()== R.id.appointment)
        {
            Intent i=new Intent(viewappointment.this,addappointment.class);
            startActivity(i);
        }

    }
    }


