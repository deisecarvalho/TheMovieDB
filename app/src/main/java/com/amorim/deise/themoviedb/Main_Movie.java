package com.amorim.deise.themoviedb;

import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main_Movie {
    public Context tContext;
    public String movieClicked;
    public Movie mMovie;
    WebServiceClient client;

/*
    public Main_Movie(Context context, String movieClicked ){
        this.tContext = context;
        this.movieClicked = movieClicked;

        client = new WebServiceClient();
        client.execute(createURL());
    }
    public Movie getMovie(){

        client.notify();

        if(client.getStatus() == AsyncTask.Status.FINISHED){
            return mMovie;
        }
        else return null;

    }*/

    public class WebServiceClient extends AsyncTask<String, Void, String> {

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
                Gson gson = new Gson();
                MovieData movie = gson.fromJson(json,MovieData.class);
                mMovie = new Movie(movie);

                notify();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String createURL(){
        String apikey = tContext.getString(R.string.api_key);
        String endpoint = tContext.getString(R.string.api_endpoint);
        String languageDevice = Resources.getSystem().getConfiguration().getLocales().toLanguageTags().substring(0,5);
        String getMovieDetails = tContext.getString(R.string.web_service_url_moviedetails);
        try{
            return endpoint + getMovieDetails + movieClicked + "?api_key=" + apikey + "&language=" + languageDevice;
        }
        catch (Exception e){e.printStackTrace(); return null;}
    }
}
