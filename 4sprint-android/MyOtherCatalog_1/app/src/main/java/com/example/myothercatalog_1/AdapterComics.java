package com.example.myothercatalog_1;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterComics extends RecyclerView.Adapter<AdapterComics.ViewHolder> {

    LayoutInflater inflater;
    List<Comics> comics;

    public AdapterComics (Context ctx, List<Comics> comics){
        this.inflater = LayoutInflater.from(ctx);
        this.comics = comics;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.comic_cell,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // bind the data
        holder.photoName.setText(comics.get(position).getPhotoName());
        holder.photoDescrip.setText(comics.get(position).getPhotoDescrip());
        Picasso.get().load(comics.get(position).getPhotoUrl()).into(holder.photoUrl);

    }

    @Override
    public int getItemCount() {
        return comics.size();
    }



    public  class ViewHolder extends  RecyclerView.ViewHolder{
        TextView photoName,photoDescrip;
        ImageView photoUrl;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            photoName = itemView.findViewById(R.id.text_name);
            photoDescrip = itemView.findViewById(R.id.text_descrip);
            photoUrl = itemView.findViewById(R.id.imagen_View);

            // handle onClick

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Do Something With this Click", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
