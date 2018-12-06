package com.example.phill.trivia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }


    // if clicked on StartQuiz
    public void StartQuiz(View view) {
        Intent intent = new Intent(getApplicationContext(),QuestionActivity.class);
        startActivity(intent);
    }

    // if clicked on Leaderboard
    public void Leaderboard(View view) {
    }
}
