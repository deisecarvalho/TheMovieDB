package com.amorim.deise.themoviedb;

import com.google.gson.annotations.SerializedName;

public class TrailerDataDetails {
    @SerializedName("key") private String key;

    public String getKey() {return key;}
    public void setKey(String key) {this.key = key;}
}
