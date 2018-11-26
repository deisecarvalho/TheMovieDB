package com.amorim.deise.themoviedb;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class GenreArrayAdapter extends RecyclerView.Adapter<GenreArrayAdapter.GenreViewHolder>{
    private LayoutInflater gInflater;
    private List<Genre> genre;
    private Context gContext;

    public GenreArrayAdapter(Context context, List<Genre> genre){
        this.gContext = context;
        this.gInflater = LayoutInflater.from(context);
        this.genre = genre;
    }

    @NonNull
    @Override
    public GenreViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = gInflater.inflate(R.layout.genre_list_item, viewGroup,false);
        GenreViewHolder viewHolder = new GenreViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GenreViewHolder genreViewHolder, int i) {
        Genre genre_ = genre.get(i);

        genreViewHolder.textView.setText(genre_.name);

    }
    @Override
    public int getItemCount() {
        return (genre == null) ? 0 : genre.size();
    }

    public static class GenreViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public GenreViewHolder(View view){
            super(view);
            textView = view.findViewById(R.id.genreNameTextView);
        }
    }

    public void swapGenreList(List<Genre> genrelist){
        this.genre.clear();
        this.genre.addAll(genrelist);
        notifyDataSetChanged();
    }
}
