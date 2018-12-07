package com.example.phill.trivia;

import java.io.Serializable;

public class ListScoreItems implements Serializable {

    String username;
    int score;

    // getters and setters for username and score
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public ListScoreItems(String username, int score){
        this.username = username;
        this.score = score;
    }




}
