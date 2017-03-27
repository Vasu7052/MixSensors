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

public class Gyro extends AppCompatActivity implements SensorEventListener{


    TextView tv4;

    SensorManager sm5;
    Sensor gyroscope;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyro);

        tv4 = (TextView) findViewById(R.id.textView14);

        sm5 = (SensorManager) getSystemService(SENSOR_SERVICE);

        gyroscope = sm5.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
    }


    @Override
    protected void onResume() {
        super.onResume();
        sm5.registerListener(this,gyroscope,sm5.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onPause() {
        super.onPause();

        sm5.unregisterListener(this);
    }


    @Override
    public void onSensorChanged(SensorEvent event) {

        NumberFormat formatter = new DecimalFormat("#0.00");
        float fffff1 = event.values[0];
        float fffff2 = event.values[1];
        float fffff3 = event.values[2];
        tv4.setText("Value of Gyroscope are : " + "\n \n" + "X Value is :- " + "" + formatter.format(fffff1) + "\n" +
                "Y Value is :-" + "" + formatter.format(fffff2) + "\n" + "Z Value is :- " + "" + formatter.format(fffff3));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
