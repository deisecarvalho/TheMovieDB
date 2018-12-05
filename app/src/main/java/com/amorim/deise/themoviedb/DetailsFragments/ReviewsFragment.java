package com.amorim.deise.themoviedb.DetailsFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amorim.deise.themoviedb.R;
import com.amorim.deise.themoviedb.Review;

import java.util.List;

public class ReviewsFragment extends Fragment {
    View view;
    private LinearLayout movieReview;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        return view = inflater.inflate(R.layout.reviews, viewGroup, false);
    }

    public void set_reviews(List <Review> reviews){
        view.findViewById(R.id.reviewsLabel).setVisibility(View.VISIBLE);

        movieReview.removeAllViews();

        for (Review review : reviews){
            TextView author = view.findViewById(R.id.reviewAuthor);
            TextView content = view.findViewById(R.id.reviewContent);
            author.setText(review.autor);
            content.setText(review.comentario);
            movieReview.addView(view);
        }
    }

}
