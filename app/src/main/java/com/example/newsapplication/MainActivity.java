package com.example.newsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView singup;
    EditText username, password;
    Button signin;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.signin_username);
        password = findViewById(R.id.signin_password);

        signin = findViewById(R.id.signin);

        singup = findViewById(R.id.signup);

        singup.setOnClickListener(view -> {
            Intent signup = new Intent(getApplicationContext(), singup.class);
            startActivity(signup);
        });

        findViewById(R.id.signin).setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), MainActivity2.class));
        });

    }
}