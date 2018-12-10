package com.example.phill.trivia;

import android.content.Context;
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
//    QuestionItems question;
    ArrayList<QuestionItems> question;
    int points;
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

        //set question
        TextView view_question = findViewById(R.id.question);
        view_question.setText((CharSequence) question.get(0));


        List<QuestionItems> ques = Arrays.asList(question.get(1),question.get(2),question.get(3),question.get(4));
        Collections.shuffle(ques);

        // set answers random
        TextView view_answer1 = findViewById(R.id.answer_1);
        TextView view_answer2 = findViewById(R.id.answer_2);
        TextView view_answer3 = findViewById(R.id.answer_3);
        TextView view_answer4 = findViewById(R.id.answer_4);

        // op een random positie moet een vraag komen
        view_answer1.setText( (CharSequence) ques.get(0));
        view_answer2.setText((CharSequence) ques.get(1));
        view_answer3.setText( (CharSequence) ques.get(2));
        view_answer4.setText( (CharSequence) ques.get(3));

        view_answer1.setOnClickListener(new AnswerClicked());
        view_answer2.setOnClickListener(new AnswerClicked());
        view_answer3.setOnClickListener(new AnswerClicked());
        view_answer4.setOnClickListener(new AnswerClicked());

    }

    // if clicked on class
    private class AnswerClicked implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            String view_correct_answer = question.get(1).toString();
            TextView clicked = (TextView) v;
            String choosen_answer = clicked.getText().toString();

            // if answer is right get point
            if (view_correct_answer == choosen_answer){
                points += 1;
            }

            ArrayList<ListScoreItems> ScoreItems = new ArrayList<>();
            Intent intent = getIntent();
            String username = intent.getStringExtra("username");
            Points = String.valueOf(points);
            ListScoreItems newitem = new ListScoreItems(username, Points );
            ScoreItems.add(newitem);

            // get next question
//            TriviaHelper helper = new TriviaHelper(this);
//            helper.getQuestion((TriviaHelper.Callback) this);
        }
    }

    @Override
    public void gotError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }


}

