package com.amorim.deise.themoviedb;

import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class Movies extends AppCompatActivity {
    private MovieAdapter mAdapter;
    private List<Movie> mMovie;
    private String movieCliked;

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
        movieCliked = (String) intent.getSerializableExtra("movieID");

        WebServiceClient client = new WebServiceClient();
        client.execute(createURL());


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
            return endpoint + getMovieDetails + movieCliked + "?api_key=" + apikey + "&language=" + languageDevice;
        }
        catch (Exception e){e.printStackTrace(); return null;}
    }
}
