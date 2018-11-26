/*package com.amorim.deise.themoviedb;

import android.content.Context;

import java.net.URL;
import java.util.List;
import java.util.Locale;

public class CreateURL {
    private Context urlContext;
    private String apikey;
    private String endpoint;
    private String languageDevice;
    private List<Genres> genresList;

    public CreateURL(Context context) {
        this.urlContext = context;
        this.apikey = urlContext.getString(R.string.api_key);
        this.endpoint = urlContext.getString(R.string.api_endpoint);
        this.languageDevice = Locale.getDefault().getDisplayLanguage();
    }

    public CreateURL(){
    }

    public String createURL_Genre(){
        try{
            String getGenre = urlContext.getString(R.string.web_service_url_genres);
            String genresURL = endpoint + getGenre + "?api_key=" + apikey + "&language=" + languageDevice;
            return genresURL;
        }
        catch (Exception e){e.printStackTrace(); return null;}
    }

    public URL createURL_Movie(int genre){
        try{
            String getMovie = urlContext.getString(R.string.web_service_url_movies);
            String genreURL = endpoint + getMovie +"?api_key=" + apikey + "&language=" + languageDevice + "&include_adult=false&include_video=false&page=1&with_genres=" + genre;
            return new URL(genreURL);
        }
        catch (Exception e){e.printStackTrace(); return null;}
    }

    public URL createURL_MovieDetails(int movie){
        try{
            String getMovieDetails = urlContext.getString(R.string.web_service_url_moviedetails);
            String MovieURL = endpoint + getMovieDetails + movie + "?api_key=" + apikey + "&language=" + languageDevice;
            return new URL(MovieURL);
        }
        catch (Exception e){e.printStackTrace(); return null;}
    }


    public List<Genres> getGenresList() {
        return genresList;
    }
}
*/