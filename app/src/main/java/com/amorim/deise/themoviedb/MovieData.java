package com.amorim.deise.themoviedb;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieData {
    @SerializedName("id") private int mId;
    @SerializedName("runtime") private int mRuntime;
    @SerializedName("title") private String mTitle;
    @SerializedName("original_title") private String mOriginalTitle;
    @SerializedName("overview") private String mOverview;
    @SerializedName("release_date") private String mReleaseDate;
    @SerializedName("backdrop_path") private String mBackdropPath;
    @SerializedName("poster_path") private String mPosterPath;
    private List<GenreDataDetails> genres;

    public int getMovieId() {return mId;}
    public void setMovieId(int mId) {this.mId = mId;}
    public int getMovieRuntime() {return mRuntime;}
    public void setMovieRuntime(int mRuntime) {this.mRuntime = mRuntime;}
    public String getMovieTitle() {return mTitle;}
    public void setMovieTitle(String mTitle) {this.mTitle = mTitle;}
    public String getMovieOriginalTitle() {return mOriginalTitle;}
    public void setMovieOriginalTitle(String mOriginalTitle) {this.mOriginalTitle = mOriginalTitle;}
    public String getMovieOverview() {return mOverview;}
    public void setMovieOverview(String mOverview) {this.mOverview = mOverview;}
    public String getMovieReleaseDate() {return mReleaseDate;}
    public void setMovieReleaseDate(String mReleaseDate) {this.mReleaseDate = mReleaseDate;}
    public String getMovieBackdropPath() {return mBackdropPath;}
    public void setMovieBackdropPath(String mBackdropPath) {this.mBackdropPath = mBackdropPath;}
    public String getMoviePosterPath() {return mPosterPath;}
    public void setMoviePosterPath(String mPosterPath) {this.mPosterPath = mPosterPath;}

    public List<GenreDataDetails> getList(){
        return genres;
    }

    public void setList(List<GenreDataDetails> genres){
        this.genres = genres;
    }

}
