package com.example.newsapplication;

public class UserDetails {
    String user_name, password, interest;


    public UserDetails(String user_name, String password, String interest) {
        this.user_name = user_name;
        this.password = password;
        this.interest = interest;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }
}
