package com.amorim.deise.themoviedb;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ListaGenerosActivity extends AppCompatActivity {
    public Integer id;
    public String name;

    public ListaGenerosActivity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
