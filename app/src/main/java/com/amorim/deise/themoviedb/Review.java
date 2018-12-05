package com.amorim.deise.themoviedb;

public class Review {
    public final String autor;
    public final String comentario;

    public Review(String autor, String comentario) {
        this.autor = autor;
        this.comentario = comentario;
    }

    Review(ReviewDataDetails data){
        this.autor = data.getAutor();
        this.comentario = data.getComentario();
    }
}
