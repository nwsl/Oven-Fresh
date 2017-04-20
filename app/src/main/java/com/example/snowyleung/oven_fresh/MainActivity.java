package com.example.snowyleung.oven_fresh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.snowyleung.oven_fresh.alarm.AlarmActivity;
import com.example.snowyleung.oven_fresh.BakerySearch.MapsActivity;
import com.example.snowyleung.oven_fresh.Schedule.ScheduleActivity;

public class MainActivity extends AppCompatActivity{

    private Button btnAlarm;
    private Button btnMap;
    private Button btnSchedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAlarm = (Button)findViewById(R.id.btnAlarm);

        btnAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AlarmActivity.class));
            }
        });

        btnMap = (Button) findViewById(R.id.btnBakery);

        btnMap.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, MapsActivity.class));
            }
        });

        btnSchedule = (Button)findViewById(R.id.btnSchedule);

        btnSchedule.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, ScheduleActivity.class));
            }
        });
    }
}