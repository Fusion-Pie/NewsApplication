package com.example.newsapplication;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {


    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {

        ImageView img_newsRequestList;
        TextView txt_newsRequestList;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);

            img_newsRequestList = itemView.findViewById(R.id.img_newsRequestList);
            txt_newsRequestList = itemView.findViewById(R.id.txt_newsRequestList);
        }
    }
}
