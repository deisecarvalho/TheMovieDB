package com.amorim.deise.themoviedb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startGenreActivity(View view){
      Intent intent = new Intent(this, Genres.class);
      startActivity(intent);
  }

}
