package com.example.fragm_rview.recyclerview;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragm_rview.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterComics extends RecyclerView.Adapter<AdapterComics.ViewHolder> {
    LayoutInflater inflater;
    List<Comics> comics;

    //Esto es para el menu context

    private int position;
    ////////////////////////////////

    public AdapterComics(FragmentManager ctx, List<Comics> comics){
        this.inflater = LayoutInflater.from(ctx);
        this.comics = comics;
    }

    //Esto es para el menu context
    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    //////////////////////////////////////

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

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                setPosition(holder.getLayoutPosition());
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return comics.size();
    }

    public  class ViewHolder extends  RecyclerView.ViewHolder
            implements View.OnCreateContextMenuListener {
        TextView photoName,photoDescrip;
        ImageView photoUrl;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            photoName = itemView.findViewById(R.id.text_name);
            photoDescrip = itemView.findViewById(R.id.text_descrip);
            photoUrl = itemView.findViewById(R.id.imagen_View);
            itemView.setOnCreateContextMenuListener(this);

            // handle onClick

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Toast.makeText(v.getContext(), "Do Something With this Click", Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view,
                                        ContextMenu.ContextMenuInfo contextMenuInfo) {

            contextMenu.add(ContextMenu.NONE, R.id.action_rv_change,
                    ContextMenu.NONE, R.string.rv_change);
            contextMenu.add(ContextMenu.NONE, R.id.action_rv_delete,
                    ContextMenu.NONE, R.string.rv_delete);



        }


    }
}