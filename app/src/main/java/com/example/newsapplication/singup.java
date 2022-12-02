package com.example.newsapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class singup extends AppCompatActivity {

    Spinner interest_ls;
    EditText username, password;
    Button singup;

    String interest = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        final MyDatabase myDatabase = new DatabaseHelper().initDb(this);
        final DatabaseDAO databaseDAO = myDatabase.UserDb();

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        singup = findViewById(R.id.createAccount);

        interest_ls = findViewById(R.id.interest_ls);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.interest_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        interest_ls.setAdapter(adapter);

        interest_ls.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                interest = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        UserDetails userDetails = new UserDetails();

                        userDetails.setUser(username.getText().toString());
                        userDetails.setPassword(password.getText().toString());
                        userDetails.setInterest("B");

                        databaseDAO.insertUser(userDetails);
                    }
                });
            }
        });
    }
}