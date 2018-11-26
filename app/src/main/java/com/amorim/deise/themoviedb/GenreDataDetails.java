package com.amorim.deise.themoviedb;

import com.google.gson.annotations.SerializedName;

public class GenreDataDetails {
    @SerializedName("name") private String gName;
    @SerializedName("id") private int gId;

    public String getGenreName(){return gName;}
    public void setGenreName(String gName){this.gName = gName;}
    public int getGenreId(){return gId;}
    public void setGenreId(int gId){this.gId = gId;}
}
