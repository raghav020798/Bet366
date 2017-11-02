package com.example.raghav.bet366;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ScheduleScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_screen);

        ArrayList<Schedule> schedules = new ArrayList<Schedule>();

        schedules.add(new Schedule("Manchester City", "Liverpool", "13 Dec 12:00",R.drawable.man_city, R.drawable.liverpool));
        schedules.add(new Schedule("Manchester United", "Barcelona", "12 Dec 12:00",R.drawable.manu, R.drawable.barcelona));

//        schedules.add(new Schedule("Everton", "Barcelona", "15 Jan 01:30",R.drawable.everton , R.drawable.barcelona));
//        schedules.add(new Schedule("Real Madrid", "Manchester City", "13 Dec 12:00",R.drawable.realmadrid, R.drawable.man_city));

        ListView listView = (ListView) findViewById(R.id.lists2);

        ScheduleAdapter scheduleAdapter = new ScheduleAdapter(this,schedules);
        listView.setAdapter(scheduleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ScheduleScreen.this, BetScreen.class);
                startActivity(intent);
            }
        });


    }
}
