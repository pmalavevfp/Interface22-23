package com.example.catalogactivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Catalog_Activity extends Fragment {
    private Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view= inflater.inflate(R.layout.catalog_activity, container, false);
        Context context =view.getContext();
        button= view.findViewById(R.id.);
        /*// Inflate the layout for this fragment
        return inflater.inflate(R.layout.catalog_activity, container, false);

        Button nav_detail = nav_detail.findViewById(R.);*/
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (context, DetailActivity.class);
                context.startActivity(intent);
            }
        });
        return  view;
    }
}