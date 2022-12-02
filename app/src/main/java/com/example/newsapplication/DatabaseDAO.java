package com.example.newsapplication;

// DAO --> Data Access object
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface DatabaseDAO {

    @Insert
    void insertUser(UserDetails newUser);

    @Query("Select User from UserTable")
    String getUser();

    @Query("Select Password from UserTable")
    String getPassword();

    @Query("Select Interest from UserTable")
    String getInterest();
}
