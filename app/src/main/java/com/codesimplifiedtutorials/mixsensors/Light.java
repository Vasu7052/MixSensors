package com.codesimplifiedtutorials.mixsensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Light extends AppCompatActivity implements SensorEventListener{

    TextView tv2;
    SensorManager sm2;
    Sensor ambient;
    ImageView iv2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);

        tv2 = (TextView) findViewById(R.id.textView5);
        iv2 = (ImageView) findViewById(R.id.imageView2);



        sm2 = (SensorManager) getSystemService(SENSOR_SERVICE);

        ambient = sm2.getDefaultSensor(Sensor.TYPE_LIGHT);

    }

    @Override
    protected void onResume() {
        super.onResume();
        sm2.registerListener(this,ambient,sm2.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onPause() {
        super.onPause();

        sm2.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        float fff = event.values[0];

        tv2.setText("Ambient value " + fff);

        if(fff==0){iv2.setImageResource(R.drawable.light_0);}
        else if(fff==2){iv2.setImageResource(R.drawable.light_0);}
        else if(fff>2&&fff<=5){iv2.setImageResource(R.drawable.light_1);}
        else if(fff>5&&fff<=10){iv2.setImageResource(R.drawable.light_2);}
        else if(fff>10&&fff<=15){iv2.setImageResource(R.drawable.light_3);}
        else if(fff>15&&fff<=50){iv2.setImageResource(R.drawable.light_4);}
        else if(fff>50&&fff<=100){iv2.setImageResource(R.drawable.light_4);}



    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
