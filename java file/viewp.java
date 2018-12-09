package com.example.hp.medicare;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class viewp extends AppCompatActivity
{
    EditText opd;
    DatabaseP db;
    Button btnview;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewp);
        db=new DatabaseP (this);
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
                String OPD=opd.getText().toString();
                Cursor result=db.getpatients(OPD);
                if (OPD.equals(""))
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

                    Buffer.append("NAME: "+result.getString(0)+"\n");
                    Buffer.append("DATED: "+result.getString(1)+"\n");
                    Buffer.append("OPD NO: "+result.getString(2)+"\n");
                    Buffer.append("AGE: "+result.getString(3)+"\n");
                    Buffer.append("COMPLAINT: "+result.getString(4)+"\n");
                    Buffer.append("MEDICINE: "+result.getString(5)+"\n");
                    Buffer.append("TESTS: "+result.getString(6)+"\n");
                    Buffer.append("DOCTOR NAME : "+result.getString(7)+"\n");


                    //}
                    displaypatient("Patient List",Buffer.toString());

                }
            }
        });
    }

}
