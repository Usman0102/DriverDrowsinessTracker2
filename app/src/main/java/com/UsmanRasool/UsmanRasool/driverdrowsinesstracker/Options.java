package com.UsmanRasool.UsmanRasool.driverdrowsinesstracker;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Options extends AppCompatActivity implements View.OnClickListener {

    LinearLayout l0, l1, l2;
    TextView t0, t1, t2;

    Button userGuideBtn;
    Button ratebtn;
    Button mapsbtn;
    Button graphbtn;
    String user = "Driver";
    int drink = 0;
    String good = "..";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_options);

        userGuideBtn = (Button) findViewById(R.id.userGuide);
        ratebtn = (Button) findViewById(R.id.Ratebtn);
        mapsbtn = (Button)  findViewById(R.id.mapsbtn);
        graphbtn = (Button)  findViewById(R.id.graphbtn);

        l0 = (LinearLayout) findViewById(R.id.screen0);
        l1 = (LinearLayout) findViewById(R.id.screen1);
        l2 = (LinearLayout) findViewById(R.id.screen2);

        t0 = (TextView) findViewById(R.id.txtBt0);
        t1 = (TextView) findViewById(R.id.txtBt1);
        t2 = (TextView) findViewById(R.id.txtBt2);

        t0.setOnClickListener(this);
        t1.setOnClickListener(this);
        t2.setOnClickListener(this);


        /**
         * Rate this app button or feedback button
         */



        ratebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("Market details" + "com.android.chrome")));

                }catch (ActivityNotFoundException e){

                    startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName() )));
                }
            }
        });

        /**
         * Button to view maps
         */


        mapsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://maps.google.com/maps?saddr=43.655033,-79.3977568&daddr=\"almaida\""));
                startActivity(intent);
            }
        });

        /**
         * for showing the accuracy in percentage or in graphs
         */

        graphbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Options.this,
                        Graphs.class);
                startActivity(myIntent);
            }
        });

        userGuideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Options.this,
                        UserGuide.class);
                startActivity(myIntent);
            }
        });





    }


    /**
     * if else statement for changing views in same activity
     */


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.txtBt0){
            l0.setVisibility(View.GONE);
            l1.setVisibility(View.VISIBLE);
        } else if (view.getId() == R.id.txtBt1){
            l1.setVisibility(View.GONE);
            l2.setVisibility(View.VISIBLE);
        } else if (view.getId() == R.id.txtBt2){
            l2.setVisibility(View.GONE);
            l0.setVisibility(View.VISIBLE);
            finish();

        }
    }
}
