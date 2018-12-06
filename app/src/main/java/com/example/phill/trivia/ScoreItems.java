package com.example.phill.trivia;

public class ScoreItems {

    String username;
    int score;

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

    public ScoreItems(String username, int score){
        this.username = username;
        this.score = score;
    }
}
