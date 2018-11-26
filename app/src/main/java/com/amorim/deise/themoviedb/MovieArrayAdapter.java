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
import java.util.List;

public class MovieArrayAdapter extends RecyclerView.Adapter<MovieArrayAdapter.MovieViewHolder> {
    private List<Movie> movie;
    private LayoutInflater mInflater;
    private Context mContext;

    public MovieArrayAdapter(Context context, List<Movie> movie) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.movie = movie;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.movie_list_item, viewGroup, false);
        MovieViewHolder viewHolder = new MovieViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, int i) {
        Movie movie_ = movie.get(i);

        movieViewHolder.mTitle.setText(movie_.title);
        movieViewHolder.mOriginalTitle.setText(movie_.original_title);
        movieViewHolder.mReleaseDate.setText(movie_.release_date);


        Picasso.get().load(movie_.poster_path).into(movieViewHolder.mPoster);

    }

    @Override
    public int getItemCount() {
        return (movie == null) ? 0 : movie.size();
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

    public void swapMovieList(ArrayList<Movie> movieslist){
        this.movie.clear();
        this.movie.addAll(movieslist);
        notifyDataSetChanged();
    }
}
