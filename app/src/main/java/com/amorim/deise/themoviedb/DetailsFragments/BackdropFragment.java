package com.amorim.deise.themoviedb.DetailsFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.amorim.deise.themoviedb.R;
import com.squareup.picasso.Picasso;

public class BackdropFragment extends Fragment {
    View view;


    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        return view = inflater.inflate(R.layout.backdrop, viewGroup, false);
    }


    public void set_backdrop(String url) {
        ImageView backdrop = view.findViewById(R.id.backdropImageView_Fragment);
        Picasso.get().load(url).into(backdrop);
    }

}

