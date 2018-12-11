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

public class TriviaHelper implements Response.Listener<JSONObject>, Response.ErrorListener {
    private Context context;
    private Callback callback;

    public TriviaHelper(Context context) {
        this.context = context;
    }



    public interface Callback {
        void gotQuestion(ArrayList<QuestionItems> question);

        void gotError(String message);
    }

    void getQuestion(Callback callback) {

        // link to API
        String url = "https://opentdb.com/api.php?amount=10&category=21&difficulty=easy&type=multiple";

        // request
        RequestQueue queue = Volley.newRequestQueue(this.context);
        JsonObjectRequest request = new JsonObjectRequest(url, null, this, this);
        queue.add(request);
        this.callback = callback;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        callback.gotError(error.getMessage());
    }

    @Override
    public void onResponse(JSONObject response) {
        ArrayList<QuestionItems> quest = new ArrayList<>();
        try {

            // each time pick a new question
            JSONArray question = response.getJSONArray("results");

            for (int i = 0; i < question.length(); i++) {

                JSONObject json = question.getJSONObject(i);

                String Question = json.getString("question");
                String Correct_Answer = json.getString("correct_answer");
                String Incorrect_Answers = json.getString("incorrect_answers");
                JSONArray answers = new JSONArray(Incorrect_Answers);
                String answer_1 = answers.getString(0);
                String answer_2 = answers.getString(1);
                String answer_3 = answers.getString(2);
                String answer_4 = json.getString("correct_answer");

                QuestionItems item = new QuestionItems(Question, answer_1, answer_2, answer_3, answer_4, Correct_Answer);
//
//                // add question and answers to the list
                quest.add(item);

            }

            this.callback.gotQuestion(quest);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}