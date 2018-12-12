package com.example.phill.trivia;

import java.io.Serializable;

// ListscoreItems handles the username and scores
public class ListScoreItems implements Serializable {

    String username;
    String score;

    // getters and setters for username and score
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }


    public ListScoreItems(String username, String score){
        this.username = username;
        this.score = score;
    }




}
