package com.codesimplifiedtutorials.mixsensors;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ListOfSensors extends AppCompatActivity {

    ListView lv1;
    SensorManager sm3;
    List<Sensor> all;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_sensors);
        lv1 = (ListView) findViewById (R.id.listView);

        sm3 = (SensorManager) getSystemService(SENSOR_SERVICE);

        all = sm3.getSensorList(Sensor.TYPE_ALL);

        lv1.setAdapter(new ArrayAdapter<Sensor>(this, android.R.layout.simple_list_item_1,all));

    }
}
