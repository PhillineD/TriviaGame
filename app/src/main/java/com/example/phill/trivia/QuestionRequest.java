//package com.example.phill.trivia;
//
//import android.app.Activity;
//import android.content.Context;
//import android.util.Log;
//
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.JsonObjectRequest;
//import com.android.volley.toolbox.Volley;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.util.ArrayList
//import java.util.List;
//
//import org.json.JSONObject;
//
//public class QuestionRequest implements Response.Listener<JSONObject>, Response.ErrorListener {
//    private  Callback activity;
//    Context Context;
//    String Question;
//
//    // Contructor that accepts context
//    public QuestionRequest(Context context) {
//        this.Context = context;
//    }
//
//    public interface Callback {
//        void gotQuestion(ArrayList<QuestionItems> question);
//        void gotQuestionError(String message);
//    }
//
//    //    attempt to retrieve the categories from the API
//    public void getQuestion(Callback activity){
//        this.activity = (Callback) activity;
//
//        // use Volley to create a new RequestQueue
//        RequestQueue queue = Volley.newRequestQueue(this.Context);
//
//        // create a JsonObjectRequest
//        String url = "https://opentdb.com/api.php?amount=10&category=21&difficulty=easy&type=multiple";
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, this, this);
//        queue.add(jsonObjectRequest);
//    }
//
//    //    is called when cannot get catergories
//    @Override
//    public void onErrorResponse(VolleyError error) {
//        this.activity.gotQuestionError(error.getMessage());
//    }
//
//
//    //    is called when everything goes as expected
//    @Override
//    public void onResponse(JSONObject response) {
//        ArrayList<QuestionItems> answersview = new ArrayList<QuestionItems>();
//
//        try {
//
//
//            //  we’d like to extract the array named "categories"
//            JSONArray question = response.getJSONArray("results");
//
//            //   loop over it to extract the strings that are in it
//            for(int i=0;i<question.length();i++){
//
//                JSONObject json = question.getJSONObject(i);
//
//                // save the catories in string
//                String Question = json.getString("question");
//                String Correct_Answer = json.getString("correct_answer");
//                String Incorrect_Answers = json.getString("incorrect_answers");
//                JSONArray answers = new JSONArray(Incorrect_Answers);
//                String answer_1 = answers.getString(0);
//                String answer_2 = answers.getString(1);
//                String answer_3 = answers.getString(2);
//                String answer_4 = json.getString("correct_answer");
//
//                QuestionItems item = new QuestionItems(Question, answer_1, answer_2, answer_3, answer_4, Correct_Answer);
//
//                // add question and answers to the list
//                answersview.add(item);
//            }
//
//            // pass the string back
//            this.activity.gotQuestion(answersview);
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//
//}
