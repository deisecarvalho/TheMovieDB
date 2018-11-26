package com.amorim.deise.themoviedb;

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
import java.util.Locale;

public class Movies extends AppCompatActivity{
    private RecyclerView mMoviesRecyclerView;
    private MovieArrayAdapter mAdapter;
    private List<Movie> movieList;
    private List<Genre> genreList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        mMoviesRecyclerView = findViewById(R.id.movieRecyclerView);
        movieList = new ArrayList<>();
        genreList = new ArrayList<>();
        mAdapter = new MovieArrayAdapter(this, movieList);
        mMoviesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mMoviesRecyclerView.setAdapter(mAdapter);

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
                StringBuilder stringBuilder = new StringBuilder ("");
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
                genreList.clear();
                movieList.clear();
                Gson gson = new Gson();
                MovieData movie = gson.fromJson(json,MovieData.class);
                for (GenreDataDetails datadetails : movie.getList()){
                    genreList.add(new Genre(datadetails));
                    movieList.add(new Movie(movie));
                }
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
        String languageDevice = Locale.getDefault().getDisplayLanguage();
        String getMovie = getString(R.string.web_service_url_movies);

        try{
            String genreURL = endpoint + getMovie +"?api_key=" + apikey + "&language=" + languageDevice + "&include_adult=false&include_video=false&page=1&with_genres=" + "28";
            return genreURL;
        }
        catch (Exception e){e.printStackTrace(); return null;}
    }
}
