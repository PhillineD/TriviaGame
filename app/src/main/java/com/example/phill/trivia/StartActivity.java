package com.example.phill.trivia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
        intent.putExtra("username",username.getText().toString() );

        Log.d("foutje", "StartQuiz: ");
        startActivity(intent);
        Log.d("foutje1", "StartQuiz: ");
    }


    // if clicked on Leaderboard
    public void Leaderboard(View view) {
        Intent intent = new Intent(StartActivity.this, HighScoreActivity.class);
        startActivity(intent);
    }

    // if ok clicked
    public void Ok(View view){

        Button leaderboard = findViewById(R.id.leaderboard);
        Button startquiz = findViewById(R.id.startquiz);
        Button Ok = findViewById(R.id.Ok);
        EditText username = findViewById(R.id.Username);

        leaderboard.setVisibility(View.VISIBLE);
        startquiz.setVisibility(View.VISIBLE);
        Ok.setVisibility(View.INVISIBLE);
        username.setVisibility(View.INVISIBLE);

    }
}
