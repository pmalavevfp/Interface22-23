package com.example.myothercatalog;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderComics extends RecyclerView.ViewHolder{

    private TextView comicsTextView;
    private ImageView mImagen;
    private TextView nameImg;
    private TextView descpImg;
    private Moc_Comic comic;

    public ViewHolderComics(@NonNull View itemView) {
        super(itemView);
        comicsTextView = itemView.findViewById(R.id.recyclerViewComics);
        mImagen=itemView.findViewById(R.id.imagen_View);
        nameImg=itemView.findViewById(R.id.text_name);
        descpImg=itemView.findViewById(R.id.text_descrip);
        //segun el video aqui faltan 2 variable mas para para el nombre y la descripción
        // minuto 21 del video
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int comicId=comic.getId();
                Context context = view.getContext();
                Toast.makeText(context, "Touched cell with clipId: " + comicId, Toast.LENGTH_LONG).show();

            }
        });

    }

    public void bindClip(Moc_Comic comic) {
        String title = comic.getPhotoTitle();
        this.comicsTextView.setText(title);
    }


}
