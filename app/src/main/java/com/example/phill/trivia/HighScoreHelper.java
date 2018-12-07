package com.example.phill.trivia;

import android.content.Context;

import java.util.ArrayList;

public class HighScoreHelper {
    ArrayList<ListScoreItems> scores = new ArrayList<>();
    Context context;
    Callback callback;

    public HighScoreHelper(Context context){
        this.context = context;
    }

    public  interface Callback{
        void gotscores(ArrayList<ListScoreItems> scores);
        void gotscoreserror(String message);
    }

    public void setScores(String username, int score ){
        this.callback = callback;
        ListScoreItems newscore = new ListScoreItems(username, score);
    }

    public void getScores(Context context){
        this.callback = callback;

        // hier moet een connectie komen naar de databse
    }


}
