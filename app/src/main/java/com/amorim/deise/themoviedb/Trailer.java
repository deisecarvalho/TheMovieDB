package com.amorim.deise.themoviedb;

public class Trailer {
    public final String key;


    public Trailer(String key) {
        this.key = key;
    }

    Trailer(TrailerDataDetails data){
        this.key = data.getKey();
    }
}
