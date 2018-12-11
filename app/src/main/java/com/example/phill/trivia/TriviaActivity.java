package com.example.phill.trivia;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.solver.widgets.Helper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
    int position = 0;
    String Points;
    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("foutje3", "StartQuiz: ");
//        // get the username from the player form the first screen
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        // open the screen to de the quiz
        setContentView(R.layout.activity_quiz);

        // get a new question
        TriviaHelper helper = new TriviaHelper(this);
        helper.getQuestion(this);

    }

    @Override
    public void gotQuestion(ArrayList<QuestionItems> question) {
        this.question = question;

//        QuestionItems quest = question.get(position);
        //set question
        TextView view_question = findViewById(R.id.question);
        view_question.setText(question.get(position).getQuestion_1());
        Log.d("verkeerd", "gotQuestion: " + question.get(position).getAnswer_1() );

        List<String> ques = Arrays.asList(question.get(position).getAnswer_1(),question.get(position).getAnswer_2(),question.get(position).getAnswer_3(), question.get(position).getAnswer_4());
        Collections.shuffle(ques);

        // set answers random
        TextView view_answer1 = findViewById(R.id.answer_1);
        TextView view_answer2 = findViewById(R.id.answer_2);
        TextView view_answer3 = findViewById(R.id.answer_3);
        TextView view_answer4 = findViewById(R.id.answer_4);

        // op een random positie moet een vraag komen
        view_answer1.setText(ques.get(0));
        view_answer2.setText( ques.get(1));
        view_answer3.setText( ques.get(2));
        view_answer4.setText( ques.get(3));
//
        view_answer1.setOnClickListener(new AnswerClicked());
        view_answer2.setOnClickListener(new AnswerClicked());
        view_answer3.setOnClickListener(new AnswerClicked());
        view_answer4.setOnClickListener(new AnswerClicked());

    }

    // if clicked on class
    private class AnswerClicked implements View.OnClickListener{
        private TriviaActivity context;
        @Override
        public void onClick(View v) {
            this.context = context;
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
//            new TriviaHelper(context).getQuestion(context);
            position += 1;
//            TriviaHelper helper = new TriviaHelper(context);
//            helper.getQuestion((TriviaHelper.Callback) this);

            // get a new question
            TriviaHelper help = new TriviaHelper(context);
            help.getQuestion(this.context);

            // when all questions are ask, go to score page
            if (position == 7){
//                String message = "To see your score go to leaderboard";
//                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
                Intent naviintent = new Intent(TriviaActivity.this, StartActivity.class);
                startActivity(naviintent);
            }

        }
    }

    @Override
    public void gotError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }


}

