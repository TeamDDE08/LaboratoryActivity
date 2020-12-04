package com.example.telephony;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CALL=1;
    private TextView contact1, contact2, contact3, contact4, contact5;
    ImageButton call1, call2, call3, call4, call5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contact1 = findViewById(R.id.contact1);
        contact2 = findViewById(R.id.contact2);
        contact3 = findViewById(R.id.contact3);
        contact4 = findViewById(R.id.contact4);
        contact5 = findViewById(R.id.contact5);
        call1 = findViewById(R.id.call1);
        call2 = findViewById(R.id.call2);
        call3 = findViewById(R.id.call3);
        call4 = findViewById(R.id.call4);
        call5 = findViewById(R.id.call5);


        call1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Callbutton1();
            }
        });

        call2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Callbutton2();
            }
        });

        call3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Callbutton3();
            }
        });

        call4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Callbutton4();
            }
        });

        call5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Callbutton5();
            }
        });


    }

    public void sms1 (View view){
        String Contact = "09269776588";
        Intent intent= new Intent(this,Sms.class);
        intent.putExtra("sms",Contact);
        startActivity(intent);
    }

    public void sms2 (View view){
        String Contact = "09955157122";
        Intent intent= new Intent(this,Sms.class);
        intent.putExtra("sms",Contact);
        startActivity(intent);
    }

    public void sms3 (View view){
        String Contact = "09457302087";
        Intent intent= new Intent(this,Sms.class);
        intent.putExtra("sms",Contact);
        startActivity(intent);
    }

    public void sms4 (View view){
        String Contact = "09205966054";
        Intent intent= new Intent(this,Sms.class);
        intent.putExtra("sms",Contact);
        startActivity(intent);
    }

    public void sms5 (View view){
        String Contact = "09162611234";
        Intent intent= new Intent(this,Sms.class);
        intent.putExtra("sms",Contact);
        startActivity(intent);
    }

    private void Callbutton1(){
        String number = contact1.getText().toString();
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions (MainActivity.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
        }else{
            String Dial = "tel:" + number;
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(Dial)));
        }
    }

    private void Callbutton2(){
        String number = contact2.getText().toString();
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions (MainActivity.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
        }else{
            String Dial = "tel:" + number;
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(Dial)));
        }
    }

    private void Callbutton3(){
        String number = contact3.getText().toString();
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions (MainActivity.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
        }else{
            String Dial = "tel:" + number;
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(Dial)));
        }
    }

    private void Callbutton4(){
        String number = contact4.getText().toString();
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions (MainActivity.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
        }else{
            String Dial = "tel:" + number;
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(Dial)));
        }
    }

    private void Callbutton5(){
        String number = contact5.getText().toString();
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions (MainActivity.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
        }else{
            String Dial = "tel:" + number;
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(Dial)));
        }
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Callbutton1();
                Callbutton2();
                Callbutton3();
                Callbutton4();
                Callbutton5();
            }else{
                Toast.makeText(this,"Permission DENIED!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}