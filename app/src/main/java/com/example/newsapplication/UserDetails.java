package com.example.newsapplication;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "UserTable")
public class UserDetails {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "User")
    public String User;

    @ColumnInfo(name = "Password")
    public String Password;

    @ColumnInfo(name = "Interest")
    public String Interest;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        this.User = user;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public String getInterest() {
        return Interest;
    }

    public void setInterest(String interest) {
        this.Interest = interest;
    }
}






