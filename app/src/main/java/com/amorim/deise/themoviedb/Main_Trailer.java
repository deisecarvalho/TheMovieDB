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
import java.util.List;

public class Main_Trailer {
    public Context tContext;
    public String movieClicked;
    public List<Trailer> tTrailer;
    WebServiceClientTrailer client;

    public Main_Trailer(Context context, String movieClicked ){
        this.tContext = context;
        this.movieClicked = movieClicked;

        client = new WebServiceClientTrailer();
        client.execute(createURLTrailer());
    }

    public List<Trailer> getTrailerList(){

        if (client.getStatus() == AsyncTask.Status.FINISHED) {
            return tTrailer;
        }else return null;
    }


    private class WebServiceClientTrailer extends AsyncTask<String, Void, String> {

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
                tTrailer.clear();
                Gson gson = new Gson();
                TrailerData trailer = gson.fromJson(json, TrailerData.class);
                for (TrailerDataDetails datadetails : trailer.getTrailers()){
                    tTrailer.add(new Trailer(datadetails));
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String createURLTrailer(){
        String apikey = tContext.getString(R.string.api_key);
        String endpoint = tContext.getString(R.string.api_endpoint);
        String getTrailers = tContext.getString(R.string.web_service_url_trailers);
        String getMovie = tContext.getString(R.string.web_service_url_moviedetails);
        String languageDevice = Resources.getSystem().getConfiguration().getLocales().toLanguageTags().substring(0,5);

        try{
            return endpoint + getMovie + movieClicked + getTrailers + "?api_key=" + apikey + "&language=" + languageDevice;
        }
        catch (Exception e){e.printStackTrace(); return null;}
    }
}
