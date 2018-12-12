package com.example.phill.trivia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

// Startactivy is the first activity
public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    // if clicked on StartQuiz
    public void StartQuiz(View view) {
        EditText username = findViewById(R.id.Username);
        Intent intent = new Intent(StartActivity.this ,TriviaActivity.class);

        // pass the username to TriviaActivity
        intent.putExtra("username",username.getText().toString() );
        startActivity(intent);
    }

    // if clicked on Leaderboard go to the leaderboard
    public void Leaderboard(View view) {
        Intent intent = new Intent(StartActivity.this, HighScoreActivity.class);
        startActivity(intent);
    }

    // if ok clicked, change visibility of the elements in Startactivity
    public void Ok(View view){

        // find the buttons and edittext from Startactivity
        Button leaderboard = findViewById(R.id.leaderboard);
        Button startquiz = findViewById(R.id.startquiz);
        Button Ok = findViewById(R.id.Ok);
        EditText username = findViewById(R.id.Username);

        // set visibility of the elements
        leaderboard.setVisibility(View.VISIBLE);
        startquiz.setVisibility(View.VISIBLE);
        Ok.setVisibility(View.INVISIBLE);
        username.setVisibility(View.INVISIBLE);
    }
}
