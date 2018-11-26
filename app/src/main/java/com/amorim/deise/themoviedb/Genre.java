package com.amorim.deise.themoviedb;

public class Genre {
    public final String name;
    public final int id;

    public Genre(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Genre(GenreDataDetails data){
        this.id = data.getGenreId();
        this.name = data.getGenreName();
    }

}
