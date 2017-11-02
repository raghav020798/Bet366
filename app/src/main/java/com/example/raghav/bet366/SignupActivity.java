package com.example.raghav.bet366;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    TextView text1;
    TextView text2;
    TextView text3;
    AutoCompleteTextView auto1;
    AutoCompleteTextView auto2;
    Animation uptodown;
    Animation downtoup;
    Button register;
    TextView text4;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        // setting Animation
        text1 = (TextView) findViewById(R.id.textView2);
        text2 = (TextView) findViewById(R.id.textView);
        text3 = (TextView) findViewById(R.id.textView3);
        text4 = (TextView) findViewById(R.id.textView4);

        uptodown = AnimationUtils.loadAnimation(this, R.anim.uptodown);
        text1.setAnimation(uptodown);
        text2.setAnimation(uptodown);
        text3.setAnimation(uptodown);

        auto1 = (AutoCompleteTextView) findViewById(R.id.auto1);
        auto2 = (AutoCompleteTextView) findViewById(R.id.auto2);
        register = (Button) findViewById(R.id.button);



        downtoup = AnimationUtils.loadAnimation(this, R.anim.downtoup);
        auto1.setAnimation(downtoup);
        auto2.setAnimation(downtoup);
        register.setAnimation(downtoup);
        text4.setAnimation(downtoup);

        // authentication
        mAuth = FirebaseAuth.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = auto1.getText().toString();
                String password = auto2.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                // creating user
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);

                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Toast.makeText(SignupActivity.this, "Authentication failed." ,
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(SignupActivity.this, "Authentication successful.",
                                            Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(SignupActivity.this, LeagueScreen.class);
                                    startActivity(i);

                                }
                            }

                        });

            }
        });

        text4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(i);

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }
}

