package com.example.myothercatalog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterMoc extends RecyclerView.Adapter <ViewHolderComics> {
    private ListMoc mocToBeShown;

    public AdapterMoc(ListMoc comic) {
        this.mocToBeShown = comic;
    }


    @NonNull
    @Override
    public ViewHolderComics onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 1. Necesitamos un LayoutInflater. Lo creamos a partir de un Context
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        // 2. Con el LayoutInflater, 'inflamos' el XML y generamos una View
        View cellView = inflater.inflate(R.layout.moc_comic_cell, parent, false);
        // 3. Esta View es la que pasamos al constructor de ClipViewHolder.
        //    ¡Y ya está listo!
        ViewHolderComics cellViewHolder = new ViewHolderComics(cellView);
        return cellViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderComics holder, int position) {
        // Usamos .get(position) para acceder al 'enésimo' elemento de la lista
        // O sea, el correspondiente a la posición 'position'
        Moc_Comic dataForThisCell = this.mocToBeShown.getMoc_Comic().get(position);
        // Y aquí, pintamos dataForThisCell en la celda 'holder'
        holder.bindClip(dataForThisCell);
    }

    @Override
    public int getItemCount() {

        return this.mocToBeShown.getMoc_Comic().size();
    }


}