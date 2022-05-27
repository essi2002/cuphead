package com.example.cuphead.Model;

public class User {
    private String username;
    private String password;
    private int turn;

    private int score;

    public User(String username,String password){
        this.username = username;
        this.password = password;
        this.turn = 0;
        this.score = 0;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public int getScore(){
        return this.score;
    }
    public int getTurn(){
        return this.turn;
    }

    public void setPassword(String newpassword){
        this.password = newpassword;
    }
    public void setUsername(String newUsername){
        this.username = newUsername;
    }

    public void setScore(int i) {
        this.score += i;
    }
}
