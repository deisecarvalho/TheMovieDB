package com.amorim.deise.themoviedb;

public class Movie {
    public final String mPoster;
    public final String mBackdrop;
    public final String mTitle;
    public final String mOriginalTitle;
    public final String mOverview;
    public final String mRuntime;
    public final String mReleaseDate;
    public final String mId;
    public final Boolean mVideo;

    public Movie(String mPoster, String mBackdrop, String mTitle, String mOriginalTitle, String mOverview, String mRuntime, String mReleaseDate, String mId, String genreId, String genreName, Boolean mVideo) {
        this.mPoster = mPoster;
        this.mBackdrop = mBackdrop;
        this.mTitle = mTitle;
        this.mOriginalTitle = mOriginalTitle;
        this.mOverview = mOverview;
        this.mRuntime = mRuntime;
        this.mReleaseDate = mReleaseDate;
        this.mId = mId;
        this.mVideo = mVideo;
    }

    public Movie(MovieData data){
        this.mId = String.valueOf(data.getmId());
        this.mOriginalTitle = data.getmOriginalTitle();
        this.mBackdrop = data.getmBackdrop();
        this.mPoster = data.getmPoster();
        this.mTitle = data.getmTitle();
        this.mRuntime = String.valueOf(data.getmRuntime());
        this.mReleaseDate = data.getmReleaseDate();
        this.mOverview = data.getmOverview();
        this.mVideo = data.mVideo;
    }

}
