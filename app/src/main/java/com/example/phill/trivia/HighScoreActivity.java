package com.example.phill.trivia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

// Activity for last page, displays the usernames and there scores
public class HighScoreActivity extends AppCompatActivity implements HighScoreHelper.Callback {

    ArrayList<ListScoreItems> scores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
        Intent intent = getIntent();
        HighScoreHelper helper = new HighScoreHelper(this);

        // get scores from user
        helper.getScores(this);
    }


    // if got scores succeed
    @Override
    public void gotscores(ArrayList<ListScoreItems> scores) {

        // set listview with the scores
        HighScoreAdapter adapter = new HighScoreAdapter(this, R.layout.highscore_item, scores);
        ListView scor = findViewById(R.id.ListviewScores);
        scor.setAdapter(adapter);

    }


    // if getscore failed
    @Override
    public void gotscoreserror(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    // if user click on back
    public void Start(View view) {

        // go to startactivity class
        Intent stopintent = new Intent(HighScoreActivity.this, StartActivity.class);
        startActivity(stopintent);

    }
}
