package com.amorim.deise.themoviedb;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class GenreArrayAdapter extends RecyclerView{

    public GenreArrayAdapter(@NonNull Context context) {
        super(context);
    }

    private static class ViewHolder{
        TextView genreNameTextView;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        Genres genre = getItem(position);
        ViewHolder viewHolder = null;

        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.genre_list_item, parent false);
            viewHolder.genreNameTextView = (TextView) convertView.findViewById(R.id.genreNameTextView);
        }
        else{
            viewHolder = (ViewHolder)convertView.getTag();
        }

        Context context = getContext();

        viewHolder.genreNameTextView.setText(context.getString(R.string.name, genre.name));

        return convertView;
    }
}
