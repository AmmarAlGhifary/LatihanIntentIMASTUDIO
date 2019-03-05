package com.blogspot.yourfavoritekaisar.latihanintentimastudio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.Inet4Address;

public class MainActivity extends AppCompatActivity {

    Button button, btn_Pindah, btn_Browser, btn_Camera, btn_Sms, btn_Email, btn_Phone;
    EditText edtText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        btn_Pindah = findViewById(R.id.btn_Pindah);
        edtText = findViewById(R.id.editText);
        btn_Browser = findViewById(R.id.btn_Browser);
        btn_Camera = findViewById(R.id.btn_Camera);
        btn_Sms = findViewById(R.id.btn_Sms);
        btn_Email = findViewById(R.id.btn_Email);
        btn_Phone = findViewById(R.id.btn_Phone);


        btn_Email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(MainActivity.this, EmailActivity.class);
                startActivity(pindah);

            }
        });

        btn_Sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(MainActivity.this, SmsActivity.class);
                startActivity(pindah);

            }
        });

        btn_Camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(MainActivity.this, CameraActivity.class);
                startActivity(pindah);

            }
        });

        btn_Browser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(MainActivity.this, BrowserActivity.class);
                startActivity(pindah);
            }
        });

        btn_Phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(MainActivity.this, PhoneActivity.class);
                startActivity(pindah);
            }
        });

        // TODO Pindah bawa data
        btn_Pindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Mengambil inputan dari user
                String text1 = edtText.getText().toString();

                // putExtra untuk mengirim data ke activity tujuan
                Intent bawaData = new Intent(MainActivity.this, SecondActivity.class);
                bawaData.putExtra("KEY", text1);
                startActivity(bawaData);
            }
        });

    }


    // TODO 1 Pindah Activity
    public void actionPindah(View view) {
        Intent pindah = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(pindah);
    }
}
