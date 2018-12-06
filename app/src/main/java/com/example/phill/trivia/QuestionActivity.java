package com.example.phill.trivia;

import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class QuestionActivity extends AppCompatActivity implements QuestionRequest.Callback {

    @Override
    public void gotQuestion(String Question) {

    }

    @Override
    public void gotQuestionError(String message) {

    }
}
