package com.example.raghav.bet366;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class LeagueScreen extends AppCompatActivity {

    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;
    private Button signOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league_screen);

        signOut = (Button) findViewById(R.id.signOut);

        //get firebase auth instance
        auth = FirebaseAuth.getInstance();

        //get current user
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    startActivity(new Intent(LeagueScreen.this, LoginActivity.class));
                    finish();
                }
            }
        };

        ArrayList<Leagues> leagues = new ArrayList<Leagues>();

        leagues.add(new Leagues("PREMIER LEAGUE", "English League", R.drawable.premier_leageu));
        leagues.add(new Leagues("LA LIGA", "Spanish League", R.drawable.laliga));
        //leagues.add(new Leagues("BUNDESLIGA", "German League",R.drawable.bundesliga));
        //leagues.add(new Leagues("LIGUE 1", "French League",R.drawable.ligue1));
        //leagues.add(new Leagues("SERIE A", "Italian League",R.drawable.serie_a));

        LeagueAdapter adapter = new LeagueAdapter(this,leagues);

        ListView listView = (ListView) findViewById(R.id.lists);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(LeagueScreen.this, ScheduleScreen.class);
                startActivity(intent);
            }
        });

        //

    signOut.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            signOut();
        }
    });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.league_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.signOut:
                signOut();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //sign out method
    public void signOut() {
        auth.signOut();
    }

    @Override
    public void onStart() {
        super.onStart();
        auth.addAuthStateListener(authListener);
    }
    @Override
    public void onStop() {
        super.onStop();
        if (authListener != null) {
            auth.removeAuthStateListener(authListener);
        }
    }
}

