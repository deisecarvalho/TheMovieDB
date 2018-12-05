package com.amorim.deise.themoviedb;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieData {
    @SerializedName("poster_path") public String mPoster;
    @SerializedName("backdrop_path") public String mBackdrop;
    @SerializedName("title") public String mTitle;
    @SerializedName("original_title") public String mOriginalTitle;
    @SerializedName("overview") public String mOverview;
    @SerializedName("runtime") public int mRuntime;
    @SerializedName("release_date") public String mReleaseDate;
    @SerializedName("id") public int mId;
    @SerializedName("video") public boolean mVideo;
    public List<GenreDataDetails> genres_;

    public String getmPoster() {return mPoster;}
    public void setmPoster(String mPoster) {this.mPoster = mPoster;}
    public String getmBackdrop() {return mBackdrop;}
    public void setmBackdrop(String mBackdrop) {this.mBackdrop = mBackdrop;}
    public String getmTitle() {return mTitle;}
    public void setmTitle(String mTitle) {this.mTitle = mTitle;}
    public String getmOriginalTitle() {return mOriginalTitle;}
    public void setmOriginalTitle(String mOriginalTitle) {this.mOriginalTitle = mOriginalTitle;}
    public String getmOverview() {return mOverview;}
    public void setmOverview(String mOverview) {this.mOverview = mOverview;}
    public int getmRuntime() {return mRuntime;}
    public void setmRuntime(int mRuntime) {this.mRuntime = mRuntime;}
    public String getmReleaseDate() {return mReleaseDate;}
    public void setmReleaseDate(String mReleaseDate) {this.mReleaseDate = mReleaseDate;}
    public int getmId() {return mId;}
    public void setmId(int mId) {this.mId = mId;}
    public  boolean getmVideo(){return mVideo;}
    public void setmVideo(boolean mVideo){this.mVideo = mVideo;}

    public List<GenreDataDetails> getList(){
        return genres_;
    }
    public void setList(List<GenreDataDetails> genres_){
        this.genres_ = genres_;
    }
}
