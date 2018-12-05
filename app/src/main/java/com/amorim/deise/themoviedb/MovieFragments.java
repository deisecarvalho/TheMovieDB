package com.amorim.deise.themoviedb;

import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MovieFragments extends AppCompatActivity {
    private MovieAdapter mAdapter;
    private List<Movie> mMovie;
    private String movieClicked;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        RecyclerView mMovieRecyclerView = findViewById(R.id.movieDetailsRecyclerView);
        mMovie = new ArrayList<>();
        mAdapter = new MovieAdapter(this, mMovie);
        mMovieRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mMovieRecyclerView.setAdapter(mAdapter);

        Intent intent = getIntent();
        movieClicked = (String) intent.getSerializableExtra("movieID");

        setupToolbar();

        WebServiceClient client = new WebServiceClient();
        client.execute(createURL());
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }


    private class WebServiceClient extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... URLString) {
            try{
                URL url = new URL(URLString[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                InputStream stream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                String line;
                StringBuilder stringBuilder = new StringBuilder ();
                while ((line = reader.readLine()) != null){
                    stringBuilder.append(line);
                }
                return stringBuilder.toString();
            }
            catch (Exception e){e.printStackTrace();return null;}
        }

        @Override
        protected void onPostExecute(String json) {
            try{
                mMovie.clear();
                Gson gson = new Gson();
                MovieData movie = gson.fromJson(json,MovieData.class);
                mMovie.add(new Movie(movie));
                /*for (GenreDataDetails datadetails: movie.getList()){
                    mMovie.add(new Movie(movie));
                }*/
                mAdapter.notifyDataSetChanged();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String createURL(){
        String apikey = getString(R.string.api_key);
        String endpoint = getString(R.string.api_endpoint);
        String languageDevice = Resources.getSystem().getConfiguration().getLocales().toLanguageTags();
        String getMovieDetails = getString(R.string.web_service_url_moviedetails);
        try{
            return endpoint + getMovieDetails + movieClicked + "?api_key=" + apikey + "&language=" + languageDevice.substring(0,5);
        }
        catch (Exception e){e.printStackTrace(); return null;}
    }

/*
    private String createURL(String type){
        String apikey = getString(R.string.api_key);
        String endpoint = getString(R.string.api_endpoint);
        String getMovie = getString(R.string.web_service_url_moviedetails);
        String getReviews = getString(R.string.web_service_url_review);
        String getTrailers = getString(R.string.web_service_url_trailers);
        String languageDevice = Resources.getSystem().getConfiguration().getLocales().toLanguageTags().substring(0,5);
        try{

            if(type.equals("movie")){
                return endpoint + getMovie + movieClicked + "?api_key=" + apikey + "&language=" + languageDevice;
            }else if (type.equals("review")){
                return endpoint + getMovie + movieClicked + getReviews + apikey + "&language=" + languageDevice;
            }else if(type.equals("trailer")){
                return endpoint + getMovie + movieClicked + getTrailers + "?api_key=" + apikey + "&language=" + languageDevice;
            }else return null;

        }
        catch (Exception e){e.printStackTrace(); return null;}
    }*/

}
