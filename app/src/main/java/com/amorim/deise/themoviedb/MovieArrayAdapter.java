package com.amorim.deise.themoviedb;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieArrayAdapter extends RecyclerView.Adapter<MovieArrayAdapter.MovieViewHolder> {
    private ArrayList<Movies> mMoviesList;
    private LayoutInflater mInflater;
    private Context mContext;

    public MovieArrayAdapter(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mMoviesList = new ArrayList<>();
    }

    @NonNull
    @Override
    public MovieArrayAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.movie_list_item, viewGroup, false);
        MovieViewHolder viewHolder = new MovieViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, int i) {
        Movies movie = mMoviesList.get(i);

        movie.getmOriginalTitle();
        movie.getmTitle();
        movie.getmReleaseDate();

        Picasso.get().load(movie.getmPoster()).into(movieViewHolder.mPoster);

    }

    @Override
    public int getItemCount() {
        return (mMoviesList == null) ? 0 : mMoviesList.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder{
        public TextView mTitle;
        public TextView mOriginalTitle;
        public TextView mReleaseDate;
        public ImageView mPoster;

        public MovieViewHolder(View view){
            super(view);
            mOriginalTitle = view.findViewById(R.id.movieOriginalTitleTextView);
            mTitle = view.findViewById(R.id.movieTitleTextView);
            mReleaseDate = view.findViewById(R.id.movieReleaseDateTextView);
            mPoster = view.findViewById(R.id.moviePosterImageView);

        }
    }

    public void swapMovieList(ArrayList<Movies> movieslist){
        this.mMoviesList.clear();
        this.mMoviesList.addAll(movieslist);
        notifyDataSetChanged();
    }
}
