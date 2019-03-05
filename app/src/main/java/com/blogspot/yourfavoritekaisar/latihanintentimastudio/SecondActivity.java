package com.blogspot.yourfavoritekaisar.latihanintentimastudio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView txtHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtHasil = findViewById(R.id.textView);
        Intent intent = getIntent();
        String data = intent.getStringExtra("KEY");

        txtHasil.setText(data);
    }
}
