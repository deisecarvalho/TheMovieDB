package com.amorim.deise.themoviedb;

import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private List<Genre> genreList;
    private String itemClickedId;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        genreList = new ArrayList<>();

        WebServiceClient client = new WebServiceClient();
        client.execute(createURL());
    }

    public void getMoviesByGenre(View view){
        TextView textView = view.findViewById(view.getId());
        String itemClickedText = (String) textView.getText();

        getGenreId(itemClickedText);

        Intent intent = new Intent(this, Main_Discover.class);
        Bundle bundle = new Bundle();
        bundle.putString("genreID", itemClickedId);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void getGenreId(String itemClickedText){
        for (int i=0; i < genreList.size(); i++){
            //Genre data = genreList.get(i);
            if(genreList.get(i).name.equals(itemClickedText)){
                itemClickedId = genreList.get(i).id;
                break;
            }
        }
    }

    public void startGenreActivity(View view){
      Intent intent = new Intent(this, Main_Genre.class);
      startActivity(intent);
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
