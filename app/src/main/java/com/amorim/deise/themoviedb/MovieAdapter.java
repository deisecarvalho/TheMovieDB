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

import java.util.List;

public class MovieAdapter  extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private List<Movie> mMovie;
    private LayoutInflater mInflater;

    MovieAdapter(Context context, List<Movie> mMovie){
        this.mInflater = LayoutInflater.from(context);
        this.mMovie = mMovie;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.movie_item, viewGroup, false);
        return new MovieViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, int i) {
        Movie movie_ = mMovie.get(i);

        movieViewHolder.mTitle.setText(movie_.mTitle);
        movieViewHolder.mOriginalTitle.setText(movie_.mOriginalTitle);
        movieViewHolder.mReleaseDate.setText(movie_.mReleaseDate);
        movieViewHolder.mRuntime.setText(movie_.mRuntime);
        movieViewHolder.mOverview.setText(movie_.mOverview);

        Picasso.get().load(movie_.mPoster).into(movieViewHolder.mPoster);
        Picasso.get().load(movie_.mBackdrop).into(movieViewHolder.mPoster);
    }
    @Override
    public int getItemCount() {return (mMovie == null) ? 0 : mMovie.size();}


    /*

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MovieViewHolder viewHolder = new MovieViewHolder(view);

        Movie movie_ = mMovie.get(position);
        viewHolder.mTitle.setText(movie_.mTitle);
        viewHolder.mOriginalTitle.setText(movie_.mOriginalTitle);
        viewHolder.mReleaseDate.setText(movie_.mReleaseDate);
        viewHolder.mRuntime.setText(movie_.mRuntime);
        viewHolder.mOverview.setText(movie_.mOverview);

        Picasso.get().load(movie_.mPoster).into(viewHolder.mPoster);
        Picasso.get().load(movie_.mBackdrop).into(viewHolder.mPoster);



        return null;
    }
*/
    static class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView mPoster;
        ImageView mBackdrop;
        TextView mTitle;
        TextView mOriginalTitle;
        TextView mOverview;
        TextView mRuntime;
        TextView mReleaseDate;
        TextView mId;

        MovieViewHolder(View view){
            super(view);
            mPoster = view.findViewById(R.id.posterImageView);
            mBackdrop = view.findViewById(R.id.backdropImageView);
            mTitle = view.findViewById(R.id.titleTextView);
            mOriginalTitle = view.findViewById(R.id.originalTitleTextView);
            mOverview = view.findViewById(R.id.overviewTextView);
            mRuntime = view.findViewById(R.id.runtimeTextView);
            mReleaseDate = view.findViewById(R.id.releaseDateTextView);
            mId = view.findViewById(R.id.movieDetalheId);
        }

    }

    public void swapMovieList(List<Movie>  movieslist){
        this.mMovie.clear();
        this.mMovie.addAll(movieslist);
        notifyDataSetChanged();
    }
}
