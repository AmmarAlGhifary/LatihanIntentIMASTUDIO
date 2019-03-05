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

public class BrowserActivity extends AppCompatActivity {

    Button btn_Browser;
    EditText edt_Browser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

        requestPermissions();


        edt_Browser = findViewById(R.id.edt_browser);
        btn_Browser = findViewById(R.id.btn_Browser);

        btn_Browser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String Browser = edt_Browser.getText().toString();

                Uri uri = Uri.parse("http:" + Browser);
                Intent web = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(web);

            }
        });
    }

    private void requestPermissions() {
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(BrowserActivity.this,
                Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(BrowserActivity.this,
                    Manifest.permission.READ_CONTACTS)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(BrowserActivity.this,
                        new String[]{Manifest.permission.INTERNET},1);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }
    }

}
