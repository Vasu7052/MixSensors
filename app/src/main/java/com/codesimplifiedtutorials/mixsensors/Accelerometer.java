package com.codesimplifiedtutorials.mixsensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Accelerometer extends AppCompatActivity implements SensorEventListener
{

    TextView tv5;
    SensorManager sm6;
    Sensor accelerometer;
    float ffffff1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        tv5 = (TextView) findViewById(R.id.textView14);

        sm6 = (SensorManager) getSystemService(SENSOR_SERVICE);

        accelerometer = sm6.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }


    @Override
    protected void onResume() {

        super.onResume();
        sm6.registerListener(this,accelerometer,sm6.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onPause() {

        super.onPause();

        sm6.unregisterListener(this);
    }


    @Override
    public void onSensorChanged(SensorEvent event) {


        NumberFormat formatter = new DecimalFormat("#0.00");

         ffffff1 = event.values[0];
        float ffffff2 = event.values[1];
        float ffffff3 = event.values[2];
        tv5.setText("Value of Acceleration are : " + "\n \n" + "X Value is :- " + "" + formatter.format(ffffff1) + "\n" +
                "Y Value is :-" + "" + formatter.format(ffffff2) + "\n" + "Z Value is :- " + "" + formatter.format(ffffff3));
        float x = ffffff1*70;

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
