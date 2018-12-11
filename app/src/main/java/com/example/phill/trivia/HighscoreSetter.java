package com.example.phill.trivia;

import android.app.DownloadManager;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class HighscoreSetter {
    Context context;
    public HighscoreSetter(Context context) {
        this.context = context;
    }

    // code from https://www.kompulsa.com/how-to-send-a-post-request-in-android/
    public void setScore(final String username, final int score){

        RequestQueue queue = Volley.newRequestQueue(this.context);
        String url = "https://ide50-pdikker.cs50.io:8080/list";
        Log.d("plaatsen", "setScore: " + username + score);
        StringRequest pastescore = new StringRequest(Request.Method.POST, url, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show();
                Log.d("oh oh waar", "onErrorResponse: " + error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<String, String>();
                params.put("username", username);
                params.put("scores", String.valueOf(score));
                Log.d("parameters", "setScore: " + params);
                return  params;
            }
        };
        Log.d("plakken van de score", "setScore: " + pastescore);
        queue.add(pastescore);

    }

}
