package com.example.newsapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class singup extends AppCompatActivity {

    Spinner interest_ls;
    private EditText username, password;
    Button singup;

    String interest = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        final MyDatabase myDatabase = new DatabaseHelper().initDb(this);
        final DatabaseDAO databaseDAO = myDatabase.UserDb();

        username = findViewById(R.id.signup_username);
        password = findViewById(R.id.signup_password);

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
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        final UserDetails userDetails = new UserDetails();

                        userDetails.setUser(username.getText().toString());
                        userDetails.setPassword(password.getText().toString());
                        userDetails.setInterest(interest);

                        databaseDAO.insertUser(userDetails);

                        Log.d("@debug", "run: data inserted successfully");

                        // Add intent here
                    }
                }).start();
            }
        });
    }
}