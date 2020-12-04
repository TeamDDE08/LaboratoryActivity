package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText username= (EditText)findViewById(R.id.EditText1);
        final EditText password= (EditText)findViewById(R.id.EditText2);
        Button btnLogin=(Button)findViewById(R.id.LoginBtn);
        Button btnRegister=(Button)findViewById(R.id.RegisterBtn);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username = username.getText().toString();
                String Password = password.getText().toString();

                SharedPreferences preferences=getSharedPreferences("MYPREFS",MODE_PRIVATE);

                if(Username.trim().length() > 0 && Password.trim().length() > 0){
                    String uName = null;
                    String uPassword =null;

                    if (preferences.contains("Name"))
                    {
                        uName = preferences.getString("Name", "");
                    }
                    if (preferences.contains("Password"))
                    {
                        uPassword = preferences.getString("Password", "");
                    }

                    if(Username.equals(uName) && Password.equals(uPassword)){
                        Intent DisplayScreen = new Intent(MainActivity.this,display.class);
                        startActivity(DisplayScreen);
                    }else{
                        Toast.makeText(getApplicationContext(), "Incorrect username or password", Toast.LENGTH_LONG).show();
                    }
                    }else{
                        Toast.makeText(getApplicationContext(), "Field cannot be left blank", Toast.LENGTH_LONG).show();
                }

            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerScreen = new Intent(MainActivity.this,register.class);
                startActivity(registerScreen);
            }
        });

    }
}