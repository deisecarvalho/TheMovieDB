package com.amorim.deise.themoviedb;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ReviewData {
    @SerializedName("results") private List<ReviewDataDetails> results;

    public List<ReviewDataDetails> getList(){
        return results;
    }
    public void setList(List<ReviewDataDetails> results){
        this.results = results;
    }
}
