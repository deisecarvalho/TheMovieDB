package com.amorim.deise.themoviedb;

import java.util.List;

public class GenreData {
    private List<GenreDataDetails> genres;

    public List<GenreDataDetails> getList(){
        return genres;
    }
    public void setList(List<GenreDataDetails> genres){
        this.genres = genres;
    }
}
