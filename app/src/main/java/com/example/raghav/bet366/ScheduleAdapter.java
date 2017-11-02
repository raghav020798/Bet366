package com.example.raghav.bet366;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Raghav on 01-11-2017.
 */

public class ScheduleAdapter extends ArrayAdapter<Schedule> {

    public ScheduleAdapter(Context context, ArrayList<Schedule> schedules) {
        super(context, 0, schedules);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.schedule_item, parent, false);
        }
        Schedule currentSchedule = getItem(position);

        TextView HomeTeamName = (TextView) listItemView.findViewById(R.id.home_team_name);
        HomeTeamName.setText(currentSchedule.getmHomeTeamName());

        TextView AwayTeamName = (TextView) listItemView.findViewById(R.id.away_team_name);
        AwayTeamName.setText(currentSchedule.getmAwayTeamName());

        TextView DateTime = (TextView) listItemView.findViewById(R.id.date_time);
        DateTime.setText(currentSchedule.getmDate());

        ImageView HomeTeamImage = (ImageView) listItemView.findViewById(R.id.home_team_image);
        if (currentSchedule.hasHomeImage()) {
            HomeTeamImage.setImageResource(currentSchedule.getmHomeImgResId());
            HomeTeamImage.setVisibility(View.VISIBLE);
        } else {
            HomeTeamImage.setVisibility(View.GONE);
        }

        ImageView AwayTeamImage = (ImageView) listItemView.findViewById(R.id.away_team_image);
        if (currentSchedule.hasAwayImage()) {
            AwayTeamImage.setImageResource(currentSchedule.getmAwayImgResId());
            AwayTeamImage.setVisibility(View.VISIBLE);
        } else {
            AwayTeamImage.setVisibility(View.GONE);
        }
        return listItemView;

    }
}
