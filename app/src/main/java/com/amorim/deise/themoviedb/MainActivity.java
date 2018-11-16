package com.amorim.deise.themoviedb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startListaGenero(View view) {
        Intent ListaGenerosActivity = new Intent(this, Genres.class);
        startActivity(ListaGenerosActivity);
    }

    public void startListaFilme(View view) {
        Intent ListaFilmeActivity = new Intent(this, MoviesList.class);
        startActivity(ListaFilmeActivity);
    }



    private URL createURLAuthGuestSession(Integer id){
        try{
           String apikey = getString(R.string.api_key);
           String baseURL = getString(R.string.web_service_url_auth_guest_session);
           String urlString = baseURL + apikey;

           return new URL(urlString);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
