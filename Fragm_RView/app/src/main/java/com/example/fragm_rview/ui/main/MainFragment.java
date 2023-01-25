package com.example.fragm_rview.ui.main;

import static androidx.constraintlayout.widget.StateSet.TAG;

import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.fragm_rview.Modify_Data_Fragment;
import com.example.fragm_rview.R;
import com.example.fragm_rview.recyclerview.AdapterComics;
import com.example.fragm_rview.recyclerview.Comics;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;

    FragmentTransaction fragmentTransaction;
    private RecyclerView recyclerView;
    private List<Comics> comics;
    private static  String URL="https://raw.githubusercontent.com/pmalavevfp/Interface22-23/main/API-REST/catalog.json";
    AdapterComics adapterComics;
    private RequestQueue queue;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        recyclerView = view.findViewById(R.id.recyclerViewComics);
        comics = new ArrayList<>();

        //esto es del menu contextual
        registerForContextMenu(recyclerView);



        parseJsonComics();

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int position = -1;
        try {
            position = ((AdapterComics)recyclerView.getAdapter()).getPosition();
        } catch (Exception e) {
            Log.d(TAG, e.getLocalizedMessage(), e);
            return super.onContextItemSelected(item);
        }
        switch (item.getItemId()) {
            case R.id.action_rv_change:
                // do your stuff
                Toast.makeText(getContext(),"Se modifica este item", Toast.LENGTH_LONG).show();
                break;
            case R.id.action_rv_delete:
                // do your stuff
                Toast.makeText(getContext(),"Se elimina este item", Toast.LENGTH_LONG).show();
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.main, Modify_Data_Fragment, tag)
                        .commitNow();
                break;
        }
        return super.onContextItemSelected(item);
    }

    private void  parseJsonComics(){
        queue= Volley.newRequestQueue(getContext());
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

                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                adapterComics=new AdapterComics(getParentFragmentManager(),comics);
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