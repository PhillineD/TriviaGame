package com.example.phill.trivia;

import android.content.Context;

import java.util.ArrayList;

public class HighScoreHelper {
    ArrayList<scores> scores = new ArrayList<>();
    Context context;
    Callback callback;

    public HighScoreHelper(Context context){
        this.context = context;
    }

    public  interface Callback{
        void gotscores(ArrayList<scores> scores);
        void gotscoreserror(String message);
    }

    public void getScores(Context context){
        this.callback = callback;

    }

    public void setScores(Context context){
        this.callback = callback;
    }


}
