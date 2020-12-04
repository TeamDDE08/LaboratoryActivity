package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText username=(EditText)findViewById(R.id.inputUsername);
        final EditText email=(EditText)findViewById(R.id.inputEmail);
        final EditText password=(EditText)findViewById(R.id.inputPassword);
        Button BtnRegister=(Button)findViewById(R.id.register);
        Button BtnCancel=(Button)findViewById(R.id.cancel);

        BtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);

                String User = username.getText().toString();
                String Email = email.getText().toString();
                String Password = password.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();

                if (username.length() > 1 && email.length() > 1 && password.length() > 1) {
                    editor.putString("Name", User);
                    editor.putString("Email", Email);
                    editor.putString("Password", Password);
                    editor.commit();

                    Intent loginScreen = new Intent(register.this, MainActivity.class);
                    Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_LONG).show();
                    startActivity(loginScreen);
                    } else {
                        Toast.makeText(register.this, "Field cannot be left blank", Toast.LENGTH_SHORT).show();
                    }
                }
        });

        BtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Cancel = new Intent(register.this, MainActivity.class);
                startActivity(Cancel);
            }
        });
    }
}