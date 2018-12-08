package com.example.hp.medicare;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class viewhistory extends AppCompatActivity
{
    EditText opd;
    DatabaseHistory mydb;
    Button btnview;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewhistory);
        opd=(EditText)findViewById(R.id.date);
        mydb=new DatabaseHistory(this);
        viewallpatient();

    }
    public void displaypatient(String title,String content)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(content);
        builder.show();

    }
    public  void viewallpatient()
    {
        opd=(EditText)findViewById(R.id.date);
        btnview=(Button)findViewById(R.id.view);
        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String opdno=opd.getText().toString();
                Cursor result=mydb.getpatients(opdno);
                if (opdno.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else if (result.getCount()==0)
                {
                    displaypatient("Error","NO records");
                }
                else
                {
                    StringBuffer Buffer=new StringBuffer();
                    //while (result.moveToNext())
                    //{

                    Buffer.append("OPD NO: "+result.getString(0)+"\n");
                    Buffer.append("Medical History: "+result.getString(1)+"\n");
                    Buffer.append("NOTES: "+result.getString(2)+"\n");
                    Buffer.append("CHIEF COMPLAINT: "+result.getString(3)+"\n");


                    //}
                    displaypatient("Patient List",Buffer.toString());

                }
            }
        });
    }

}