package com.example.phill.trivia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class HighScoreActivity extends AppCompatActivity implements HighScoreHelper.Callback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        HighScoreHelper helper = new HighScoreHelper(this);
//        helper.getScores(this, ); hier moet nog een verwijzing komen naar de database

    }


    @Override
    public void gotscores(ArrayList<ListScoreItems> scores) {

        //  Moet nog een adapter class komen om er steeds weer een highscore aan toe te voegen

        ListView scors = findViewById(R.id.ListviewScores);
        scores.set(adapter);

    }

    @Override
    public void gotscoreserror(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
