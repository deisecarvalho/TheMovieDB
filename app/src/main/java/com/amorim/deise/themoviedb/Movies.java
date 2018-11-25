package com.amorim.deise.themoviedb;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

public class Movies extends AppCompatActivity{
    private RecyclerView mMoviesRecyclerView;
    private String mTitle;
    private String mOriginalTitle;
    private String mReleaseDate;
    private String mRuntime;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
    }


    public String getmTitle(){return mTitle;}
    public void setmTitle(String mTitle){this.mTitle = mTitle;}
    public String getmOriginalTitle(){return mOriginalTitle;}
    public void setmOriginalTitle(String mOriginalTitle){this.mOriginalTitle = mOriginalTitle;}
    public String getmReleaseDate(){return mReleaseDate;}
    public void setmReleaseDate(String mReleaseDate){this.mReleaseDate = mReleaseDate;}
    public String getmRuntime(){return mRuntime;}
    public void setmRuntime(String mRuntime){this.mRuntime = mRuntime;}
}
