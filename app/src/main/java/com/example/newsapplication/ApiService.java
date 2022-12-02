package com.example.newsapplication;

import android.content.Context;
import android.widget.Adapter;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Queue;

public class ApiService {

    public void getNews(Context c, RecyclerView recyclerView,String category){
        RequestQueue requestQueue = Volley.newRequestQueue(c);

        String BASE_URL = "https://inshortsapi.vercel.app/news?category=" + category;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, BASE_URL, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = response.getJSONArray("data");

                            ArrayList<NewsModel> arrayList = new ArrayList<>();

                            for (int i = 0; i < jsonArray.length(); i++){
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                NewsModel newsModel = new NewsModel(jsonObject.getString("content")
                                        , jsonObject.getString("imageUrl"), jsonObject.getString("url"));

                                arrayList.add(newsModel);

                                NewsAdapter newsAdapter = new NewsAdapter(arrayList);
                                recyclerView.setAdapter(newsAdapter);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        Toast.makeText(c, "Something went wrong!!", Toast.LENGTH_SHORT).show();
                    }
                });

        requestQueue.add(jsonObjectRequest);
    }
}
