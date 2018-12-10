package com.example.phill.trivia;

import java.util.ArrayList;

public class QuestionItems extends ArrayList<QuestionItems> {

    private final String question_1, answer_1, answer_2, answer_3, answer_4, correct_answer;

    // an request contains a question and 4 answers
    public QuestionItems(String question_1, String answer_1,String  answer_2, String answer_3, String answer_4, String correct_answer) {
        this.question_1= question_1;
        this.correct_answer= correct_answer;
        this.answer_1 =answer_1;
        this.answer_2= answer_2;
        this.answer_3 =answer_3;
        this.answer_4 =answer_4;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }

    public String getQuestion_1() {
        return question_1;
    }

    public String getAnswer_1() {
        return answer_1;
    }

    public String getAnswer_2() {
        return answer_2;
    }

    public String getAnswer_3() {
        return answer_3;
    }

    public String getAnswer_4() {
        return answer_4;
    }
}
