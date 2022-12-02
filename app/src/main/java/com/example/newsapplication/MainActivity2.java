package com.example.newsapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ChipGroup chipGroup = findViewById(R.id.chip_group);

        getCategoryNews("all");

        chipGroup.setOnCheckedStateChangeListener(new ChipGroup.OnCheckedStateChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull ChipGroup group, @NonNull List<Integer> checkedIds) {
                Toast.makeText(MainActivity2.this, "" + String.valueOf(checkedIds), Toast.LENGTH_SHORT).show();

                int checked_id = checkedIds.get(0);

                String name = getResources().getResourceName(checked_id).split("/")[1].split("_")[1];

                getCategoryNews(name);
            }
        });

    }

    public void getCategoryNews(String category){

        RecyclerView news_recyclerView = findViewById(R.id.news_recyclerView);

        news_recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiService apiService = new ApiService();

        apiService.getNews(getApplicationContext(), news_recyclerView, category);
    }
}