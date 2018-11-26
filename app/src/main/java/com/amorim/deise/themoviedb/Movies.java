package com.amorim.deise.themoviedb;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.annotations.SerializedName;

public class Movies extends AppCompatActivity{
    private RecyclerView mMoviesRecyclerView;
    @SerializedName("id") private int mGenreId;
    @SerializedName("name") private String mGenreName;
    @SerializedName("title") private String mTitle;
    @SerializedName("original_title") private String mOriginalTitle;
    @SerializedName("release_date") private String mReleaseDate;
    @SerializedName("poster_path") private String mPoster;
    private MovieArrayAdapter mAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        mMoviesRecyclerView = findViewById(R.id.movieRecyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false);

        mAdapter = new MovieArrayAdapter(this);
        mMoviesRecyclerView.setLayoutManager(linearLayoutManager);
        mMoviesRecyclerView.setAdapter(mAdapter);
    }


    public String getmTitle(){return mTitle;}
    public void setmTitle(String mTitle){this.mTitle = mTitle;}
    public String getmOriginalTitle(){return mOriginalTitle;}
    public void setmOriginalTitle(String mOriginalTitle){this.mOriginalTitle = mOriginalTitle;}
    public String getmReleaseDate(){return mReleaseDate;}
    public void setmReleaseDate(String mReleaseDate){this.mReleaseDate = mReleaseDate;}
    public String getmPoster(){

        return "https://api.themoviedb.org/3/movie/200/images?api_key=3d300a0230a2d4a14ee863b22e2ea788&language=en-US";}
    public void setmPoster(String mPoster){this.mPoster = mPoster;}
}
