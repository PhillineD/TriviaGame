package com.example.phill.trivia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class HighScoreActivity extends AppCompatActivity implements HighScoreHelper.Callback {

    ArrayList<ListScoreItems> scores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        HighScoreHelper helper = new HighScoreHelper(this);

        // get scores from user
        helper.getScores(this);


    }


    @Override
    public void gotscores(ArrayList<ListScoreItems> scores) {
        this.scores = scores;

        ListView scor = findViewById(R.id.ListviewScores);
        scor.setFilterText(scores.get(0)+ ":" + scores.get(1) );

    }


    @Override
    public void gotscoreserror(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
