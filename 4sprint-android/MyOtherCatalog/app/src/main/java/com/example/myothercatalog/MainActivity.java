package com.example.myothercatalog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ListMoc comics;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.recyclerView = findViewById(R.id.recyclerViewComics);
        comics = (ListMoc) comics.getMoc_Comic();
        setClips(comics);
        queue= Volley.newRequestQueue(this);

        ParseJson();
    }

    public ListMoc getMoc_Comics() {return comics;}

    public void setClips(ListMoc comics) {
        this.comics = comics;
        AdapterComics myAdapter = new AdapterComics(this.comics);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void ParseJson(){
        String url="https://raw.githubusercontent.com/pmalavevfp/Interface22-23/main/API-REST/catalog.json";
        JsonObjectRequest queue= new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                for (int i=0; i<response.length();i++){
                    JSONObject comicsObject = response.getJSONObject(i);
                    Moc_Comic comic = new Moc_Comic():

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }
}