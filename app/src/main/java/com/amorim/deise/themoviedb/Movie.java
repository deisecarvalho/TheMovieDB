package com.amorim.deise.themoviedb;

import java.util.List;

public class Movie {

    public final int id;
    public final int runtime;
    public final String title;
    public final String original_title;
    public final String overview;
    public final String release_date;
    public final String backdrop_path;
    public final String poster_path;
    public final List<GenreDataDetails> genres;


    public Movie(int id, String title, String original_title, String overview, String release_date, List<GenreDataDetails> genres, String backdrop_path, String poster_path, int runtime) {
        this.id = id;
        this.title = title;
        this.original_title = original_title;
        this.overview = overview;
        this.release_date = release_date;
        this.genres = genres;
        this.backdrop_path = backdrop_path;
        this.poster_path = poster_path;
        this.runtime = runtime;
    }

    public Movie(MovieData data){
        this.id = data.getMovieId();
        this.title = data.getMovieTitle();
        this.original_title = data.getMovieOriginalTitle();
        this.overview = data.getMovieOverview();
        this.release_date = data.getMovieReleaseDate();
        this.backdrop_path = data.getMovieBackdropPath();
        this.poster_path = data.getMoviePosterPath();
        this.runtime = data.getMovieRuntime();
        this.genres = data.getList();
    }

}
