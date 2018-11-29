package com.amorim.deise.themoviedb;

import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Discover extends AppCompatActivity{
    private mDiscoverArrayAdapter dAdapter;
    private List<mDiscover> discoverList;
    private String GenreCliked;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover_list);
        RecyclerView dDiscoverRecyclerView = findViewById(R.id.movieRecyclerView);
        discoverList = new ArrayList<>();
        dAdapter = new mDiscoverArrayAdapter(this, discoverList);
        dDiscoverRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        dDiscoverRecyclerView.setAdapter(dAdapter);

        Intent intent = getIntent();
        GenreCliked = (String) intent.getSerializableExtra("genreID");

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
                discoverList.clear();
                Gson gson = new Gson();
                mDiscoverData discover = gson.fromJson(json,mDiscoverData.class);
                for (mDiscoverDataDetails datadetails: discover.getList()){
                    discoverList.add(new mDiscover(datadetails));
                }
                dAdapter.notifyDataSetChanged();
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
        String getMovie = getString(R.string.web_service_url_movies);

        try{
            Log.d("id", GenreCliked);
            return endpoint + getMovie +"?api_key=" + apikey + "&language=" + languageDevice + "&include_adult=false&include_video=false&page=1&with_genres=" + GenreCliked;
        }
        catch (Exception e){e.printStackTrace(); return null;}
    }
}
