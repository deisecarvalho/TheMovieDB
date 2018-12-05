package com.amorim.deise.themoviedb;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

public class DiscoverArrayAdapter extends RecyclerView.Adapter<DiscoverArrayAdapter.MovieViewHolder> {
    private List<Discover> mDiscover;
    private LayoutInflater dInflater;
    private Context dContext;

    DiscoverArrayAdapter(Context context, List<Discover> mDiscover) {
        this.dContext = context;
        this.dInflater = LayoutInflater.from(dContext);
        this.mDiscover = mDiscover;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = dInflater.inflate(R.layout.discover_list_item, viewGroup, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, int i) {
        Discover mDiscover_ = mDiscover.get(i);

        movieViewHolder.mTitle.setText(mDiscover_.title);
        movieViewHolder.mOriginalTitle.setText(mDiscover_.original_title);
        movieViewHolder.mReleaseDate.setText(mDiscover_.release_date);
        movieViewHolder.mId.setText(mDiscover_.id);
        movieViewHolder.mPopularity.setText(mDiscover_.popularity);

        Picasso.get().load(dContext.getString(R.string.base_url_getPoster) + mDiscover_.poster_path).into(movieViewHolder.mPoster);
    }

    @Override
    public int getItemCount() {
        return (mDiscover == null) ? 0 : mDiscover.size();
    }

    static class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView mTitle;
        TextView mOriginalTitle;
        TextView mReleaseDate;
        ImageView mPoster;
        TextView mId;
        TextView mPopularity;

        MovieViewHolder(View view){
            super(view);
            mOriginalTitle = view.findViewById(R.id.movieOriginalTitleTextView);
            mTitle = view.findViewById(R.id.movieTitleTextView);
            mReleaseDate = view.findViewById(R.id.movieReleaseDateTextView);
            mPoster = view.findViewById(R.id.posterImageView);
            mId = view.findViewById(R.id.movieId);
            mPopularity = view.findViewById(R.id.moviePopularity);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent movieIntent = new Intent(v.getContext(), MovieFragments.class);
            Bundle bundle_ = new Bundle();
            bundle_.putString("movieID", (String) mId.getText());
            movieIntent.putExtras(bundle_);
            v.getContext().startActivity(movieIntent);
        }
    }

    public void swapMovieList(ArrayList<Discover> movieslist){
        this.mDiscover.clear();
        this.mDiscover.addAll(movieslist);
        notifyDataSetChanged();
    }


}
