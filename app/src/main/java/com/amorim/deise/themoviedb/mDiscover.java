package com.amorim.deise.themoviedb;

import java.util.List;

public class mDiscover {

    public final String id;
    public final String title;
    public final String original_title;
    public final String release_date;
    public final String poster_path;
    public final List<Integer> genre_ids;


    public mDiscover(String id, String title, String original_title, String release_date, String poster_path, List<Integer> genre_ids) {
        this.id = id;
        this.title = title;
        this.original_title = original_title;
        this.release_date = release_date;
        this.poster_path = poster_path;
        this.genre_ids = genre_ids;
    }

    mDiscover(mDiscoverDataDetails data){
        this.id = String.valueOf(data.getMovieId());
        this.title = data.getMovieTitle();
        this.original_title = data.getMovieOriginalTitle();
        this.release_date = data.getMovieReleaseDate();
        this.poster_path = "https://image.tmdb.org/t/p/w154" + data.getMoviePosterPath();
        this.genre_ids = data.getList();
    }
}
