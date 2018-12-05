package com.amorim.deise.themoviedb;

import java.util.List;

public class Discover {

    public final String id;
    public final String title;
    public final String original_title;
    public final String release_date;
    public final String poster_path;
    public final List<Integer> genre_ids;
    public final String popularity;


    public Discover(String id, String title, String original_title, String release_date, String poster_path, List<Integer> genre_ids, String popularity) {
        this.id = id;
        this.title = title;
        this.original_title = original_title;
        this.release_date = release_date;
        this.poster_path = poster_path;
        this.genre_ids = genre_ids;
        this.popularity = popularity;
    }

    Discover(DiscoverDataDetails data){
        this.id = String.valueOf(data.getMovieId());
        this.title = data.getMovieTitle();
        this.original_title = data.getMovieOriginalTitle();
        this.release_date = data.getMovieReleaseDate().substring(0,4);
        this.poster_path = data.getMoviePosterPath();
        this.genre_ids = data.getList();
        this.popularity = String.valueOf(data.getmPopularity());
    }
}
