package com.codesimplifiedtutorials.mixsensors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {


    ImageButton im1,im2,im3,im4,im5,im6,im8,im9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        im1 = (ImageButton) findViewById(R.id.imageButton);
        im2 = (ImageButton) findViewById(R.id.imageButton2);
        im3 = (ImageButton) findViewById(R.id.imageButton3);
        im4 = (ImageButton) findViewById(R.id.imageButton4);
        im5 = (ImageButton) findViewById(R.id.imageButton5);
        im6 = (ImageButton) findViewById(R.id.imageButton6);



        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(MainActivity.this,ListOfSensors.class);
                startActivity(i1);
            }
        });

        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(MainActivity.this,Proximity.class);
                startActivity(i2);
            }
        });

        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(MainActivity.this,Light.class);
                startActivity(i3);
            }
        });
        im4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4 = new Intent(MainActivity.this,Gravity.class);
                startActivity(i4);
            }
        });
        im5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i5 = new Intent(MainActivity.this,Gyro.class);
                startActivity(i5);
            }
        });

        im6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i6 = new Intent(MainActivity.this,Accelerometer.class);
                startActivity(i6);
            }
        });


    }

}
