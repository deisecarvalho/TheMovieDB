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

public class OverviewFragment extends Fragment {
    View view;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        return view = inflater.inflate(R.layout.overview, viewGroup, false);
    }

    public void set_overview(Movie movie){
        TextView overview = view.findViewById(R.id.overviewTextView_Fragment);

        overview.setText(movie.mOverview);
    }
}
