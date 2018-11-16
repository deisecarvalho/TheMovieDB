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
        Intent ListaGenerosActivity = new Intent(this, ListaGenerosActivity.class);
        startActivity(ListaGenerosActivity);
    }

    public void startListaFilme(View view) {
        Intent ListaFilmeActivity = new Intent(this, ListaFilmeActivity.class);
        startActivity(ListaFilmeActivity);
    }



    private URL createURLGenre(Integer id){
        try{
            String apiKey = getString(R.string.api_key);
            String baseURLGenre = getString(R.string.web_service_url_genres);
            String urlString = baseURLGenre + "?api_key=" + apiKey
        }
    }
}
