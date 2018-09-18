package com.UsmanRasool.UsmanRasool.driverdrowsinesstracker;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AppInfoActivity extends AppCompatActivity {

    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_info);

        activity=this;
        PackageInfo pInfo = null;
        try {
            pInfo = getPackageManager().getPackageInfo(
                    this.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        int versionCode = pInfo.versionCode;
        String versionName = pInfo.versionName;

       // TextView versionCodeTextView = (TextView) findViewById(R.id.version_code);
       // versionCodeTextView.setText("VersionCode:" + Integer.toString(versionCode));

        TextView version = (TextView) findViewById(R.id.version);
        version.setText("Version : " + versionName);

        TextView opensource_license = (TextView) findViewById(R.id.opensource_license);

        final String license_txt="Mobile Vision"
               ;

        opensource_license.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                //Open popup window
                try {
                    Common.PopupDialog(activity,license_txt);

                }catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        Button close_btn = (Button)findViewById(R.id.close_btn);
        close_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                try {
                    finish();
                }catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });


    }
}
