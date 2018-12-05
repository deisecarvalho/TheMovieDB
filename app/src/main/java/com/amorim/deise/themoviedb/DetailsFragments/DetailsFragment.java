package com.amorim.deise.themoviedb.DetailsFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amorim.deise.themoviedb.Movie;
import com.amorim.deise.themoviedb.R;

public class DetailsFragment extends Fragment {
    View view;
    TextView title;
    TextView originalTitle;
    TextView releaseDate;
    TextView runtime;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        return view = inflater.inflate(R.layout.details, viewGroup, false);
    }

    public void set_details(Movie movie){
        title = view.findViewById(R.id.titleTextView_Fragment);
        originalTitle = view.findViewById(R.id.originalTitleTextView_Fragment);
        releaseDate = view.findViewById(R.id.releaseDateTextView_Fragment);
        runtime = view.findViewById(R.id.runtimeTextView_Fragment);

        title.setText(movie.mTitle);
        originalTitle.setText(movie.mOriginalTitle);
        releaseDate.setText(movie.mReleaseDate);
        runtime.setText(movie.mRuntime);
    }
}
