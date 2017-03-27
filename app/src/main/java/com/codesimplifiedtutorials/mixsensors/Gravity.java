package com.codesimplifiedtutorials.mixsensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Gravity extends AppCompatActivity implements SensorEventListener{

    TextView tv3,tv33,tv333,tv3333;

    SensorManager sm4;
    Sensor gravity;
    float standardGravity,thresholdGraqvity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gravity);

        tv3 = (TextView) findViewById(R.id.textSt);
        tv33 = (TextView) findViewById(R.id.textTh);
        tv333 = (TextView) findViewById(R.id.textZ);
        tv3333 = (TextView) findViewById(R.id.textFace);

        sm4 = (SensorManager) getSystemService(SENSOR_SERVICE);

        gravity = sm4.getDefaultSensor(Sensor.TYPE_GRAVITY);

        standardGravity = SensorManager.STANDARD_GRAVITY;
        thresholdGraqvity = standardGravity/2;

        tv3.setText("Standard Gravity : - " + standardGravity);
        tv33.setText("Threshold : " + thresholdGraqvity);
    }


    @Override
    protected void onResume() {
        super.onResume();
        sm4.registerListener(this,gravity,sm4.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onPause() {
        super.onPause();

        sm4.unregisterListener(this);
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        float ffff3 = event.values[2];

        NumberFormat formatter = new DecimalFormat("#0.00");
        tv333.setText( "Gravity value is " + "" + formatter.format(ffff3));

        if(ffff3>=thresholdGraqvity){

                tv3333.setText("Your Mobile is Facing UP");
        }

        else if(ffff3<-thresholdGraqvity){tv3333.setText("Your Mobile is Facing DOWN");}
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
