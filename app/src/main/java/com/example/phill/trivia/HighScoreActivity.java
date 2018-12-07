package com.example.phill.trivia;

import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class HighScoreActivity extends AppCompatActivity implements HighScoreHelper.Callback {
    @Override
    public void gotscores(ArrayList<scores> scores) {

    }

    @Override
    public void gotscoreserror(String message) {

    }
}
