package com.blogspot.yourfavoritekaisar.latihanintentimastudio;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PhoneActivity extends AppCompatActivity {

    EditText edt_Phone;
    Button btn_Phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        btn_Phone = findViewById(R.id.btn_pindahTelpon);
        edt_Phone = findViewById(R.id.edt_Telpon);

        // TODO Contoh Intent Implicit
        btn_Phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String noTelp = edt_Phone.getText().toString();

                Intent dialPhone = new Intent(Intent.ACTION_DIAL);
                dialPhone.setData(Uri.parse("tel:" + noTelp));
                startActivity(dialPhone);
            }
        });

    }
}
