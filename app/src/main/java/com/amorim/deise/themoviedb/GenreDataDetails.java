package com.amorim.deise.themoviedb;

import com.google.gson.annotations.SerializedName;

class GenreDataDetails {
    @SerializedName("name") private String gName;
    @SerializedName("id") private int gId;

    String getGenreName(){return gName;}
    int getGenreId(){return gId;}
}
