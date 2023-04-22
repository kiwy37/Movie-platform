package com.example.movie_recomandation;

import java.time.LocalDate;

public class Movie {
    String movie;
    String category;
    LocalDate releaseDate;
    int likes;
    public String getMovie() {
        return movie;
    }
    public Movie() {
        // Initialize fields to default values
        this.movie = "";
        this.category = "";
        this.releaseDate = LocalDate.MIN;
        this.likes = 0;
    }
    public String getCategory() {
        return category;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public int getLikes() {
        return likes;
    }
    public void setMovie(String movie) {
        this.movie = movie;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
