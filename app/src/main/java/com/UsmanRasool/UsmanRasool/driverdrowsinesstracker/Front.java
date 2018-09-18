package com.UsmanRasool.UsmanRasool.driverdrowsinesstracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Usman Rasool on 4/14/2018.
 */

public class Front extends AppCompatActivity {

    Button  trackingbtn;
    Button userGuide;
    Button accuracybtn;

    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);


        trackingbtn = (Button) findViewById(R.id.trackingbtn);
        userGuide = (Button) findViewById(R.id.userGuide);

        /**
         * Button action to start tracking
         */

        trackingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Front.this,
                        Options.class);
                startActivity(myIntent);
            }
        });

        /**
         * Button to view user guide
         */


        userGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Front.this,
                        UserGuide.class);
                startActivity(myIntent);
            }
        });









    }
}
