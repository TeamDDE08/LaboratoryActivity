package com.example.telephony;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Sms extends AppCompatActivity {

    EditText editNum, editMessage;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        editNum = findViewById(R.id.editNum);
        editMessage = findViewById(R.id.editMessage);

        Bundle sms = getIntent().getExtras();
        String SMS = sms.getString("sms");
        editNum.setText(String.valueOf(SMS));
    }

    public void btnSend(View view) {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            sendMessage();

        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 0);
        }
    }

    private void sendMessage() {
        String number, message;

        number = editNum.getText().toString().trim();
        message = editMessage.getText().toString().trim();

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(number, null, message, null, null);

        Toast.makeText(this, "Message Sent", Toast.LENGTH_SHORT).show();
    }
}