package com.example.hp.medicare;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText e1,e2;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new DatabaseHelper(this);
        e1=(EditText)findViewById(R.id.email);
        e2=(EditText)findViewById(R.id.pass);
        b1=(Button)findViewById(R.id.login);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=e1.getText().toString();
                String password=e2.getText().toString();
                Boolean chkemailpass=db.emailpassword(email,password);
                if (chkemailpass==true) {
                    Toast.makeText(getApplicationContext(), "suceesful login", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, firstpage.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(getApplicationContext(),"invalid credentials",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void OnTextClick(View v)
    {
        if (v.getId()== R.id.register)
        {
            Intent i=new Intent(MainActivity.this,signup.class);
            startActivity(i);
        }

    }
}
