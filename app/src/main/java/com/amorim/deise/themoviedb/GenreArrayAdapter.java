package com.amorim.deise.themoviedb;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class GenreArrayAdapter extends RecyclerView.Adapter<GenreArrayAdapter.GenreViewHolder>{
    private LayoutInflater gInflater;
    private List<Genre> genre;


    GenreArrayAdapter(Context context, List<Genre> genre){
        this.gInflater = LayoutInflater.from(context);
        this.genre = genre;
    }

    @NonNull
    @Override
    public GenreViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = gInflater.inflate(R.layout.genre_list_item, viewGroup,false);
        return new GenreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GenreViewHolder genreViewHolder, int i) {
        Genre genre_ = genre.get(i);

        genreViewHolder.nameTextView.setText(genre_.name);
        genreViewHolder.idTextView.setText(genre_.id);

    }
    @Override
    public int getItemCount() {
        return (genre == null) ? 0 : genre.size();
    }

    static class GenreViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView nameTextView;
        TextView idTextView;


        GenreViewHolder(View view){
            super(view);
            nameTextView = view.findViewById(R.id.genreNameTextView);
            idTextView = view.findViewById(R.id.genreIdTextView);
            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Log.d((String) v.getTag(),"Onclick" + getAdapterPosition() + idTextView.getText());

            Intent intent = new Intent(v.getContext(), Discover.class);
            Bundle bundle = new Bundle();
            bundle.putString("genreID", (String) idTextView.getText());
            intent.putExtras(bundle);
            v.getContext().startActivity(intent);
        }
    }

    public void swapGenreList(List<Genre> genrelist){
        this.genre.clear();
        this.genre.addAll(genrelist);
        notifyDataSetChanged();
    }
}
