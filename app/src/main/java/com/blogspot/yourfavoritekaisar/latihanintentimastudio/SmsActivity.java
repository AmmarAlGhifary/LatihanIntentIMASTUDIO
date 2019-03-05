package com.blogspot.yourfavoritekaisar.latihanintentimastudio;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SmsActivity extends AppCompatActivity {

    Button btn_Sms;
    EditText edt_Sms, edt_Sms2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        requestPermissions();

        btn_Sms = findViewById(R.id.btn_Sms);
        edt_Sms = findViewById(R.id.edt_Sms);
        edt_Sms2 = findViewById(R.id.edt_Sms2);

        btn_Sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String noTelp = edt_Sms.getText().toString();
                String sms = edt_Sms2.getText().toString();

                Uri uri = Uri.parse("smsto:" + noTelp);
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO, uri);
                smsIntent.putExtra("sms_body", sms);
                startActivity(smsIntent);
//                smsIntent.putExtra("address", noTelp);
//                smsIntent.setType("vnd.android-dir/mms-sms");
            }
        });
    }

    private void requestPermissions(){
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(SmsActivity.this,
                Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(SmsActivity.this,
                    Manifest.permission.READ_CONTACTS)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(SmsActivity.this,
                        new String[]{Manifest.permission.READ_CONTACTS},1);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }
    }

}
