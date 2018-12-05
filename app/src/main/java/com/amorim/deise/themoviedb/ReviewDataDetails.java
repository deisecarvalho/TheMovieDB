package com.amorim.deise.themoviedb;

import com.google.gson.annotations.SerializedName;

public class ReviewDataDetails {
    @SerializedName("author") private String autor;
    @SerializedName("content") private String comentario;

    String getAutor() {return autor;}
    public void setAutor(String autor) {this.autor = autor;}
    String getComentario() {return comentario;}
    public void setComentario(String comentario) {this.comentario = comentario;}
}
