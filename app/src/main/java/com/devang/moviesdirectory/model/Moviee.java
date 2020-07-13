package com.devang.moviesdirectory.model;

import java.io.Serializable;

public class Moviee implements Serializable {

    private String title;
    private String director;
    private String year;
    private String runTime;
    private String imdb;
    private String poster;
    private String genre;
    private String writer;
    private String actors;
    private String plote;
    private String rating;
    private String dvdRelease;
    private String productioncompany;
    private String country;
    private String awards;
    private String tvrated;
    private String moviewType;

    public Moviee()
    {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPlote() {
        return plote;
    }

    public void setPlote(String plote) {
        this.plote = plote;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDvdRelease() {
        return dvdRelease;
    }

    public void setDvdRelease(String dvdRelease) {
        this.dvdRelease = dvdRelease;
    }

    public String getProductioncompany() {
        return productioncompany;
    }

    public void setProductioncompany(String productioncompany) {
        this.productioncompany = productioncompany;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getTvrated() {
        return tvrated;
    }

    public void setTvrated(String tvrated) {
        this.tvrated = tvrated;
    }

    public String getMoviewType() {
        return moviewType;
    }

    public void setMoviewType(String moviewType) {
        this.moviewType = moviewType;
    }
}
