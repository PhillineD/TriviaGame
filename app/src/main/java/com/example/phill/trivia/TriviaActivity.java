package com.example.phill.trivia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
//implements QuestionRequest.Callback

public class TriviaActivity extends AppCompatActivity implements TriviaHelper.Callback {
    QuestionItems question;
    int points,position;
    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // get the username from the player form the first screen
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        // open the screen to de the quiz
        setContentView(R.layout.activity_quiz);

        // get a new question
        TriviaHelper helper = new TriviaHelper(this);
        helper.getQuestion(this);

    }

    @Override
    public void gotQuestion(QuestionItems question) {
        this.question = question;

        //set question
        TextView view_question = findViewById(R.id.question);
        view_question.setText(question.getQuestion_1());

        // set answers
        TextView view_answer1 = findViewById(R.id.answer_1);
        TextView view_answer2 = findViewById(R.id.answer_2);
        TextView view_answer3 = findViewById(R.id.answer_3);
        TextView view_answer4 = findViewById(R.id.answer_4);

        // nu word het goede antwoord altijd op de laatse positie geplaatst
        view_answer1.setText(question.getAnswer_1());
        view_answer2.setText(question.getAnswer_2());
        view_answer3.setText(question.getAnswer_3());
        view_answer4.setText(question.getAnswer_4());


    }

    @Override
    public void gotError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    public void Answer_clicked(View view ){

        // check if answer was good
        String view_correct_answer = question.getCorrect_answer();
        TextView clicked = (TextView) view;
        String choosen_answer = clicked.getText().toString();
        if (view_correct_answer == choosen_answer){
            points += 1;
        }

        // get next question
        TriviaHelper helper = new TriviaHelper(this);
        helper.getQuestion(this);
    }

}

