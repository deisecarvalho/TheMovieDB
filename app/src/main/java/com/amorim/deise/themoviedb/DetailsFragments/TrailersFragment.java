package com.amorim.deise.themoviedb.DetailsFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.amorim.deise.themoviedb.R;
import com.amorim.deise.themoviedb.Trailer;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TrailersFragment extends Fragment {
    View view;
    private LinearLayout movieTrailers;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        return view = inflater.inflate(R.layout.trailers, viewGroup, false);
    }

    public void set_traiers(List<Trailer> trailers){
        view.findViewById(R.id.trailersLabel).setVisibility(View.VISIBLE);
        movieTrailers.removeAllViews();

        for (Trailer trailer : trailers){
            ImageView trailerThumbnail = view.findViewById(R.id.thumbnail);
            Picasso.get().load(getContext().getString(R.string.base_url_getVideoThumbnail) + trailer.key + "/0.jpg").into(trailerThumbnail);
            movieTrailers.addView(view);
        }




    }
}
