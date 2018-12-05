package com.amorim.deise.themoviedb;

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

public class Main_Genre extends AppCompatActivity{
    private GenreArrayAdapter gAdapter;
    private List<Genre> genreList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre_list);
        RecyclerView gGenresRecyclerView = findViewById(R.id.genreRecyclerView);
        genreList = new ArrayList<>();
        gAdapter = new GenreArrayAdapter(this,genreList );
        gGenresRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        gGenresRecyclerView.setAdapter(gAdapter);

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
                genreList.clear();
                Gson gson = new Gson();
                GenreData genre = gson.fromJson(json,GenreData.class);
                for (GenreDataDetails datadetails : genre.getList()){
                    genreList.add(new Genre(datadetails));
                }
                gAdapter.notifyDataSetChanged();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String createURL(){
        String apikey = getString(R.string.api_key);
        String endpoint = getString(R.string.api_endpoint);
        String languageDevice = Resources.getSystem().getConfiguration().getLocales().toLanguageTags().substring(0,5);
        String getGenre = getString(R.string.web_service_url_genres);

        try{
            return endpoint + getGenre + "?api_key=" + apikey + "&language=" + languageDevice;
        }
        catch (Exception e){e.printStackTrace(); return null;}
    }
}
