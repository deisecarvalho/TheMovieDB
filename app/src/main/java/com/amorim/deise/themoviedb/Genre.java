package com.amorim.deise.themoviedb;

public class Genre {
    public final String name;
    public final String id;

    public Genre(String id, String name){
        this.id = id;
        this.name = name;
    }

    Genre(GenreDataDetails data){
        this.id = String.valueOf(data.getGenreId());
        this.name = data.getGenreName();
    }

    public String getId() {
        return id;
    }
}
