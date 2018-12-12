package com.example.phill.trivia;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

// class for GET request, to get the username en score form url
public class HighScoreHelper implements Response.ErrorListener, Response.Listener<JSONArray> {

    Context context;
    Callback callback;

    // contructor
    public HighScoreHelper(Context context) {
        this.context = context;
    }

    public interface Callback {
        void gotscores(ArrayList<ListScoreItems> scores);
        void gotscoreserror(String message);
    }

    // get high score from server
    public void getScores(Callback callback) {
        this.callback = callback;

        // url to server with the scores from the users
        String url = "https://ide50-pdikker.cs50.io:8080/list";

        // request
        RequestQueue queue = Volley.newRequestQueue(context);
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,url,null, this, this);
        queue.add(request);

    }


    @Override
    public void onErrorResponse(VolleyError error) {
        callback.gotscoreserror(error.getMessage());
    }



    @Override
    public void onResponse(JSONArray response) {

        // Arraylist for Highscore items
        ArrayList<ListScoreItems> quest = new ArrayList<>();

        try {

            // each time pick a new object, with a username and a score from that username
            for (int i = 0; i < response.length(); i++) {

                    // get JSON object from server at position i
                    JSONObject json = response.getJSONObject(i);

                    // get username and score from JSON file in url
                    String Username = json.getString("username");
                    String Score = json.getString("scores");

                    // put username and score in class
                    ListScoreItems score = new ListScoreItems(Username, Score);

                    // add class object to list
                    quest.add(score);
            }

            callback.gotscores(quest);

         // if failed
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}