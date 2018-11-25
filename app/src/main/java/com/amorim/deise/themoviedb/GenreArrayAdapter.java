package com.amorim.deise.themoviedb;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class GenreArrayAdapter extends RecyclerView.Adapter<GenreArrayAdapter.GenreViewHolder>{
    private ArrayList<String> gGenresList;
    private LayoutInflater gInflater;
    private Context gContext;

    public GenreArrayAdapter(Context context){
        this.gContext = context;
        this.gInflater = LayoutInflater.from(context);
        this.gGenresList = new ArrayList<>();
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
        genreViewHolder.textView.setText((CharSequence) gGenresList.get(i));
    }

    @Override
    public int getItemCount() {
        return (gGenresList == null) ? 0 : gGenresList.size();
    }

    public static class GenreViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public GenreViewHolder(View view){
            super(view);
            textView = (TextView) view.findViewById(R.id.genreNameTextView);
        }

    }

    public void swapGenreList(ArrayList<String> genrelist){
        this.gGenresList.clear();
        this.gGenresList.addAll(genrelist);
        notifyDataSetChanged();
    }
}
