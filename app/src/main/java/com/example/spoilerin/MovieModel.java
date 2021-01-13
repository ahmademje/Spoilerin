package com.example.spoilerin;

import java.io.Serializable;

public class MovieModel implements Serializable {
    String id;
    String title;
    String overview;
    String posterPath;

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public MovieModel(String id, String title, String overview) {
        this.id = id;
        this.title = title;
        this.overview = overview;
    }

    public MovieModel(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
