package com.blogspot.yourfavoritekaisar.latihanintentimastudio;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EmailActivity extends AppCompatActivity {

    Button btn_KirimEmail;
    EditText edt_Subjek, edt_TujuanEmail, edt_WriteEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        edt_TujuanEmail = findViewById(R.id.edt_TujuanEmail);
        edt_Subjek = findViewById(R.id.edt_Subject);
        edt_WriteEmail = findViewById(R.id.edt_WriteEmail);

        btn_KirimEmail = findViewById(R.id.btn_EmailKirim);

        btn_KirimEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Email = edt_TujuanEmail.getText().toString();
                String Subjek = edt_Subjek.getText().toString();
                String message = edt_WriteEmail.getText().toString();

                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{Email});
                emailIntent.putExtra(Intent.EXTRA_TEXT, Subjek);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,  message);
                emailIntent.setType("message/rfc822");
                startActivity(Intent.createChooser(emailIntent, "Send Email..."));
            }
        });
    }
}
