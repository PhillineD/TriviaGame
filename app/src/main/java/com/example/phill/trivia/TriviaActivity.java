package com.example.phill.trivia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// TriviaActivty is the game-activity
public class TriviaActivity extends AppCompatActivity implements TriviaHelper.Callback {

    ArrayList<QuestionItems> question;
    int points;
    int position = 0;
    String Points;

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         // get the username from the player form the first screen
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        // open the screen to  the quiz
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
        view_question.setText(Html.fromHtml( question.get(position).getQuestion_1()));

        // generate random answers
        List<String> ques = Arrays.asList(question.get(position).getAnswer_1(),question.get(position).getAnswer_2(),question.get(position).getAnswer_3(), question.get(position).getAnswer_4());
        Collections.shuffle(ques);

        // find textvieuws
        TextView view_answer1 = findViewById(R.id.answer_1);
        TextView view_answer2 = findViewById(R.id.answer_2);
        TextView view_answer3 = findViewById(R.id.answer_3);
        TextView view_answer4 = findViewById(R.id.answer_4);

        // set answer text
        view_answer1.setText( Html.fromHtml(ques.get(0)));
        view_answer2.setText( Html.fromHtml(ques.get(1)));
        view_answer3.setText( Html.fromHtml(ques.get(2)));
        view_answer4.setText( Html.fromHtml(ques.get(3)));

        // if clicked on answer
        view_answer1.setOnClickListener(new AnswerClicked());
        view_answer2.setOnClickListener(new AnswerClicked());
        view_answer3.setOnClickListener(new AnswerClicked());
        view_answer4.setOnClickListener(new AnswerClicked());

    }

    // if home clicked
    public void home(View view) {

        // set points and position back
        points = 0;
        position = 0;

        // go to startactivty
        Intent stopintent = new Intent(TriviaActivity.this, StartActivity.class);

        // get messege on screen
        Toast.makeText(TriviaActivity.this, "game stopped", Toast.LENGTH_LONG).show();
        startActivity(stopintent);
    }

    // if clicked on an answer
    private class AnswerClicked implements View.OnClickListener{
        private TriviaActivity context;
        @Override
        public void onClick(View v) {

            // get correct answer
            String view_correct_answer = question.get(position).getCorrect_answer();
            TextView clicked = (TextView) v;

            // get choosen asnwer
            String choosen_answer = clicked.getText().toString();

            // if choosen answer equel to correct answer, get a point
            if (view_correct_answer == choosen_answer){
                points += 1;

                // messege on screen
                Toast.makeText(TriviaActivity.this, "Yeah right answer", Toast.LENGTH_LONG).show();
            }

            // if answer is wrong user not get a point
            else{

                // messege on screen
                Toast.makeText(TriviaActivity.this, "Unfortunately, wrong answer", Toast.LENGTH_LONG).show();
            }

            // fill new arraylist w
            ArrayList<ListScoreItems> ScoreItems = new ArrayList<>();
            Intent intent = getIntent();
            String username = intent.getStringExtra("username");
            Points = String.valueOf(points);
            ListScoreItems newitem = new ListScoreItems(username, Points );
            ScoreItems.add(newitem);

            // set textview with curret points
            TextView viewpoints = findViewById(R.id.TextPoints);
            viewpoints.setText("POINTS:"+ " " + points);

            // position for next question
            position += 1;

            // get a new question
            TriviaHelper help = new TriviaHelper(getApplicationContext());
            help.getQuestion(TriviaActivity.this);

            if (position == 7){

                // set new score after 7 questions
                HighscoreSetter post = new HighscoreSetter(TriviaActivity.this);
                post.setScore(username,points);

                // if 7 questions are answered
                Intent pintent = new Intent(TriviaActivity.this, HighScoreActivity.class);
                Toast.makeText(TriviaActivity.this, "Points : " + Points, Toast.LENGTH_LONG).show();
                startActivity(pintent);
            }



        }
    }

    @Override
    public void gotError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }


}

