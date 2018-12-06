package com.example.phill.trivia;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList

import org.json.JSONObject;

public class QuestionRequest implements Response.Listener<JSONObject>, Response.ErrorListener {
    Context Context;
    Activity activity;
    String Question;

    // Contructor that accepts context
    public QuestionRequest(Context context) {
        this.Context = context;
    }

    public interface Callback {
        void gotQuestion(String Question);
        void gotQuestionError(String message);
    }

    //    attempt to retrieve the categories from the API
    public void getQuestion(Callback activity){
        this.activity = (Activity) activity;

        // use Volley to create a new RequestQueue
        RequestQueue queue = Volley.newRequestQueue(this.Context);

        // create a JsonObjectRequest
        String url = "https://opentdb.com/api.php?amount=10&category=21&difficulty=easy&type=multiple";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, this, this);
        queue.add(jsonObjectRequest);
    }

    //    is called when cannot get catergories
    @Override
    public void onErrorResponse(VolleyError error) {
        this.activity.gotQuestionError(error.getMessage());
    }


    //    is called when everything goes as expected
    @Override
    public void onResponse(JSONObject response) {

        try {

            //  we’d like to extract the array named "categories"
            JSONArray question = response.getJSONArray("question");

            //   loop over it to extract the strings that are in it
            for(int i=0;i<question.length();i++){

                // save the catories in string
                String Question = question.getString(i);
            }

            // pass the string back
            this.activity.gotQuestion(Question);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



}
