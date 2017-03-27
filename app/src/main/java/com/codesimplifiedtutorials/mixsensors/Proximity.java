package com.codesimplifiedtutorials.mixsensors;

import android.graphics.drawable.AnimationDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Proximity extends AppCompatActivity implements SensorEventListener{

    TextView tv1;
    SensorManager sm1;
    Sensor proximity;
    ImageView iv1;
    AnimationDrawable lightAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity);

        tv1 = (TextView) findViewById(R.id.textView3);
        iv1 = (ImageView) findViewById(R.id.imageView);







        sm1 = (SensorManager) getSystemService(SENSOR_SERVICE);
        proximity = sm1.getDefaultSensor(Sensor.TYPE_PROXIMITY);
    }



    @Override
    protected void onResume() {
        super.onResume();

        sm1.registerListener(Proximity.this,proximity,sm1.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();

        sm1.unregisterListener(Proximity.this);
    }


    @Override
    public void onSensorChanged(SensorEvent event) {

        float ff = event.values[0];

        tv1.setText("Proximity Value is : - " + "" + ff);

        if(ff==0){
            iv1.setBackgroundResource(R.drawable.animation_light);

            lightAnimator = (AnimationDrawable) iv1.getBackground();
            lightAnimator.start();
        }

        else if(ff==5f){

            iv1.setBackgroundResource(R.drawable.animation_light_reverse);

            lightAnimator = (AnimationDrawable) iv1.getBackground();

            lightAnimator.start();

        }


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {



    }
}
