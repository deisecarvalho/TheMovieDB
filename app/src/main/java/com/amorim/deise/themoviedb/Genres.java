package com.amorim.deise.themoviedb;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Genres extends AppCompatActivity{
    private RecyclerView gGenresRecyclerView;
    private String gGenreName;
    private String gGenreId;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre_list);

        gGenresRecyclerView = (RecyclerView) findViewById(R.id.genreRecyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false);
        GenreArrayAdapter gAdapter = new GenreArrayAdapter(this);
        gGenresRecyclerView.setLayoutManager(linearLayoutManager);
        gGenresRecyclerView.setAdapter(gAdapter);


        ArrayList<String> moviesList = new ArrayList<>();
        moviesList.add("Liga da Justiça");
        moviesList.add("Mulher-Maravilha");
        moviesList.add("The Matrix");
        moviesList.add("Interstellar");
        moviesList.add("Batman: The Dark Knight");
        gAdapter.swapGenreList(moviesList);

    }

    public String getgGenreName(){return gGenreName;}
    public void setgGenreName(String gGenreName){this.gGenreName = gGenreName;}
    public String getgGenreId(){return gGenreId;}
    public void setgGenreId(String id){this.gGenreId = id;}


}
