package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity
{
    EditText username1,password1;
    Button login1;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username1 = findViewById(R.id.username1);
        password1 = findViewById(R.id.password1);
        login1 = findViewById(R.id.btnlogin1);
        DB = new DBHelper(this);

        login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username1.getText().toString();
                String pass = password1.getText().toString();
                if (user.isEmpty() || pass.isEmpty())
                {
                    Toast.makeText(LoginActivity.this,"Please Enter all the Fields",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if (checkuserpass)
                    {
                        Toast.makeText(LoginActivity.this,"Sign in  successfully",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                        finish();
                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this,"Invalid Credential ",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}