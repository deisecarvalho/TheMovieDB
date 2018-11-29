package com.amorim.deise.themoviedb;

import com.google.gson.annotations.SerializedName;

public class MovieDataDetails {
    @SerializedName("name") private String gName;
    @SerializedName("id") private int gId;

    String getGName(){return gName;}
    int getGId(){return gId;}
}
