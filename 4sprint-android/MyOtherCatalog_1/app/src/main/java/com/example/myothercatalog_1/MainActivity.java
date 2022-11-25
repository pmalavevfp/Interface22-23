package com.example.myothercatalog_1;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

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
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Comics> comics;
    private static  String URL="https://raw.githubusercontent.com/pmalavevfp/Interface22-23/main/API-REST/catalog.json";
    AdapterComics adapterComics;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewComics);
        comics = new ArrayList<>();

        parseJsonComics();

    }

    private void  parseJsonComics(){
        queue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(Request.Method.GET, URL, null, new Response.Listener<JSONArray>() {
            //JsonObjectRequest queue= new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject comicsObject = response.getJSONObject(i);

                        Comics comic = new Comics();
                        comic.setPhotoName(comicsObject.getString("name").toString());
                        comic.setPhotoDescrip(comicsObject.getString("description").toString());
                        comic.setPhotoUrl(comicsObject.getString("image_url"));

                        comics.add(comic);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapterComics=new AdapterComics(getApplicationContext(),comics);
                recyclerView.setAdapter(adapterComics);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("tag", "onErrorResponse"+ error.getMessage());
            }
        });

        queue.add(jsonArrayRequest);
    }
}