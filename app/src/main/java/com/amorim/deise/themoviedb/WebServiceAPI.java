/*package com.amorim.deise.themoviedb;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class WebServiceAPI {
    private String genericURL;
    private List<Genres> genres;

    public WebServiceAPI(String genericURL, List<Genres> genres){
        this.genericURL = genericURL;
        this.genres = genres;

        WebServiceClient client = new WebServiceClient();
        client.execute(genericURL);
    }

    private class WebServiceClient extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... URLString) {
            try{
                URL url = new URL(URLString[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                InputStream stream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                String linha = null;
                StringBuilder stringBuilder = new StringBuilder ("");
                while ((linha = reader.readLine()) != null){
                    stringBuilder.append(linha);
                }
                return stringBuilder.toString();
            }
            catch (Exception e){e.printStackTrace();return null;}
        }

        @Override
        protected void onPostExecute(String json) {
            try{
                genres.clear();
                Gson gson = new Gson();
                Genres gGenres = gson.fromJson(json,Genres.class);
                for (int i = 0; i < gGenres.getGenres().size(); i++){
                    genres.add(gGenres);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
*/