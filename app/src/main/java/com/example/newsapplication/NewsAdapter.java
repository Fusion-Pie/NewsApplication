package com.example.newsapplication;

import android.content.Intent;
import android.opengl.EGLImage;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    List<NewsModel> list;

    public NewsAdapter(List<NewsModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
//    the method links java and xml
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_list, parent, false);
        return new NewsViewHolder(view);
    }


    // setting
    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        NewsModel newsModel = list.get(position);
        holder.txt_newsRequestList.setText(newsModel.getContent());
        // Glide --> Image loader library
//      to convert url to img
        Glide.with(holder.img_newsRequestList.getContext()).load(newsModel.getImageUrl()).into(holder.img_newsRequestList);

        holder.share.setOnClickListener(view -> {
            Intent myIntent = new Intent(Intent.ACTION_SEND);
            myIntent.setType("text/plain");
            String shareBody = newsModel.getUrl();
            myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
            holder.share.getContext().startActivity(Intent.createChooser(myIntent, "Share using"));
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {

        ImageView img_newsRequestList;
        TextView txt_newsRequestList, share;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);

            img_newsRequestList = itemView.findViewById(R.id.img_newsRequestList);
            txt_newsRequestList = itemView.findViewById(R.id.txt_newsRequestList);
            share = itemView.findViewById(R.id.share);
        }
    }
}
