package com.example.phill.trivia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
//implements QuestionRequest.Callback

public class QuestionActivity extends AppCompatActivity {

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

////        // instantiate your adapter
////        QuestionRequest adapter = new QuestionRequest(this);
////        adapter.getQuestion(this);
////
////        // toast for test
////        Toast.makeText(this, "started", Toast.LENGTH_SHORT).show();
    }
////    @Override
////    public void gotQuestion(ArrayList<QuestionItems> question ) {
////        // Toast for test
//////        Toast.makeText(this, question.get(0), Toast.LENGTH_LONG).show();
////        ArrayAdapter<String> QuestionAdapter = new ArrayAdapter<String>();
////
////        QuestionItems.
////        //attach the question to the textview
////        String  = new adapter(this, )
////
////        // Find Text place for the question
////        TextView TextQuestion = findViewById(R.id.question);
////        TextQuestion.setAdapter(adapter);
////
////    }
////
////    @Override
////    public void gotQuestionError(String message) {
////        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
////    }
}
