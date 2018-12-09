package com.example.hp.medicare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    DatabaseHelper db;
    EditText e1,e2,e3,e4;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        db=new DatabaseHelper(this);
        e4=(EditText)findViewById(R.id.name);
        e1=(EditText)findViewById(R.id.email);
        e2=(EditText)findViewById(R.id.pass);
        e3=(EditText)findViewById(R.id.cpass);
        b1=(Button)findViewById(R.id.register);

        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                String s3=e3.getText().toString();
                String s4=e3.getText().toString();

                if (s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")){
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();

                }
                else {
                    if (s2.equals(s3)){
                        Boolean chkemail=db.chkemail(s1);
                        if (chkemail==true){
                            Boolean insert=db.insert(s4,s1,s2);
                            if (insert==true){
                                Toast.makeText(getApplicationContext(),"registered sucessfully",Toast.LENGTH_SHORT).show();

                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"email already registered",Toast.LENGTH_SHORT).show();

                        }

                    }
                    else {
                        Toast.makeText(getApplicationContext(), "password does not match", Toast.LENGTH_SHORT).show();
                    }
                }



            }


        });
    }
    public void onButtonClick(View v)
    {
        if (v.getId()== R.id.login)
        {
            Intent i=new Intent(signup.this,MainActivity.class);
            startActivity(i);
        }

    }
}
