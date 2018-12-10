package com.example.phill.trivia;

import android.content.Context;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.ListIterator;

public class HighScoreHelper implements Response.ErrorListener, Response.Listener<JSONObject> {
    ArrayList<ListScoreItems> Highscores = new ArrayList<>();
    Context context;
    Callback callback;

    public HighScoreHelper(Context context) {
        this.context = context;
    }

    public interface Callback {
        void gotscores(ArrayList<ListScoreItems> scores);

        void gotscoreserror(String message);
    }

    // get high score from server
    public void getScores(Context context) {
        this.callback = callback;

        // url to server with the scores from the users
        String url = "https://ide50-pdikker.cs50.io:8080/list";

        // request
        RequestQueue queue = Volley.newRequestQueue(context);
        JsonObjectRequest request = new JsonObjectRequest(url, null, this, this);
        queue.add(request);

    }


    @Override
    public void onErrorResponse(VolleyError error) {
        callback.gotscoreserror(error.getMessage());
    }


    public void setScores(String username, String score) {
        this.callback = callback;
        ListScoreItems newscore = new ListScoreItems(username, score);
        Highscores.add(newscore);
        // create an new jason object
//        JSONObject json = new JSONObject();
    }


    @Override
    public void onResponse(JSONObject response) {
        ArrayList<ListScoreItems> quest = new ArrayList<>();
        try {

            // each time pick a new scores, with a username and a score from that username
            JSONArray question = response.getJSONArray("scores");
//            ArrayList<ListScoreItems> quest = new ArrayList<>();
            for (int i = 0; i < question.length(); i++) {

                JSONObject json = question.getJSONObject(i);

                String Username = json.getString("username");
                String Score = json.getString("score");

                ListScoreItems score = new ListScoreItems(Username, Score);

//                // add question and answers to the list
                quest.add(score);

            }

            callback.gotscores(quest);

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

}