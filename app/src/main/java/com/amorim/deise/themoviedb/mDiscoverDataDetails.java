package com.amorim.deise.themoviedb;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class mDiscoverDataDetails {

    @SerializedName("id") private int mId;
    @SerializedName("title") private String mTitle;
    @SerializedName("original_title") private String mOriginalTitle;
    @SerializedName("release_date") private String mReleaseDate;
    @SerializedName("poster_path") private String mPosterPath;
    private List<Integer> genres_ids;

    public int getMovieId() {return mId;}
    public void setMovieId(int mId) {this.mId = mId;}
    public String getMovieTitle() {return mTitle;}
    public void setMovieTitle(String mTitle) {this.mTitle = mTitle;}
    public String getMovieOriginalTitle() {return mOriginalTitle;}
    public void setMovieOriginalTitle(String mOriginalTitle) {this.mOriginalTitle = mOriginalTitle;}
    public String getMovieReleaseDate() {return mReleaseDate;}
    public void setMovieReleaseDate(String mReleaseDate) {this.mReleaseDate = mReleaseDate;}
    public String getMoviePosterPath() {return mPosterPath;}
    public void setMoviePosterPath(String mPosterPath) {this.mPosterPath = mPosterPath;}
    public List<Integer> getList(){
        return genres_ids;
    }
    public void setList(List<Integer> genres_ids){
        this.genres_ids = genres_ids;
    }
}

