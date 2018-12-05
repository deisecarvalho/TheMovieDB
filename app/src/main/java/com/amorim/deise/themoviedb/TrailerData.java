package com.amorim.deise.themoviedb;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TrailerData {
    @SerializedName("id") private int tId;
    @SerializedName("results") private List<TrailerDataDetails> trailers;

    public int gettId() {return tId;}
    public void settId(int tTd) {this.tId = tTd;}

    public List<TrailerDataDetails> getTrailers() {return trailers;}
    public void setTrailers(List<TrailerDataDetails> trailers) {this.trailers = trailers;}
}
