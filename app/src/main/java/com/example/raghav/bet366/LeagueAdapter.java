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
 * Created by Raghav on 30-10-2017.
 */

public class LeagueAdapter extends ArrayAdapter<Leagues> {
    public LeagueAdapter(Context context, ArrayList<Leagues> words) {
        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.league_item, parent, false);
        }
        Leagues currentLeageu = getItem(position);

        TextView LeagueName = (TextView) listItemView.findViewById(R.id.leaguename);

        LeagueName.setText(currentLeageu.getmLeagueName());

        TextView LeagueRegion = (TextView) listItemView.findViewById(R.id.leagueregion);

        LeagueRegion.setText(currentLeageu.getmLeagueRegion());

        ImageView LeagueLogo = (ImageView) listItemView.findViewById(R.id.imageView);

        if(currentLeageu.hasImage()){
            LeagueLogo.setImageResource(currentLeageu.getImageResourceId());
            LeagueLogo.setVisibility(View.VISIBLE);
        }
        else {
            LeagueLogo.setVisibility(View.GONE);
        }

        return listItemView;
    }
}