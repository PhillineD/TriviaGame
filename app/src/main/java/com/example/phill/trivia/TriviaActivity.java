package com.example.phill.trivia;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.solver.widgets.Helper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//implements QuestionRequest.Callback

public class TriviaActivity extends AppCompatActivity implements TriviaHelper.Callback {
    QuestionItems question;
    int points,position;
    String Points;
    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        // get the username from the player form the first screen
//        Intent intent = getIntent();
//        String username = intent.getStringExtra("username");

        // open the screen to de the quiz
        setContentView(R.layout.activity_quiz);

        // get a new question
        TriviaHelper helper = new TriviaHelper(this);
        helper.getQuestion(this);

    }

    @Override
    public void gotQuestion(ArrayList<QuestionItems> question) {
        this.question = question;
        List<String> ques = Arrays.asList(question.get(0),question.get(1),question.get(),question.getAnswer_4());
        Collections.shuffle(ques);        //set question
        TextView view_question = findViewById(R.id.question);
        view_question.setText(question.getQuestion_1());

        // set answers random
        TextView view_answer1 = findViewById(R.id.answer_1);
        TextView view_answer2 = findViewById(R.id.answer_2);
        TextView view_answer3 = findViewById(R.id.answer_3);
        TextView view_answer4 = findViewById(R.id.answer_4);

        // op een random positie moet een vraag komen
        view_answer1.setText(ques.get(0));
        view_answer2.setText(ques.get(1));
        view_answer3.setText(ques.get(2));view_answer4.setText(ques.get(3));

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

        // get the username from the player form the first screen
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        Points = String.valueOf(points);
        ListScoreItems newitem = new ListScoreItems(username, Points );

        // get next question
        TriviaHelper helper = new TriviaHelper(this);
        helper.getQuestion(this);
    }

}

