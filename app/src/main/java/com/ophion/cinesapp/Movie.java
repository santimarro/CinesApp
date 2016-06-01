package com.ophion.cinesapp;

/**
 * Created by smarro on 5/23/16.
 */
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Movie implements Serializable{

    private String title, genre;
    private String[] cines = new String[5];
    // Array con los cines ubicados: Olmos, NuevoCentro, Showcase, Gran Rex, Cinerama

    public Movie() {
    }

    public Movie(String title, String genre, String [] cines) {
        this.title = title;
        this.genre = genre;
        this.cines = cines;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public void setSchedule(String [] schedules) {
        for (int i = 0; i < 5; i++) {
            this.cines[i] = schedules[i];
        }
    }

    public String getSchedule(int cine) {
        return this.cines[cine];
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}