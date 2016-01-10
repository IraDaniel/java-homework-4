package com.company.task4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ira on 20.12.2015.
 */
public class MovieCollection implements Serializable {


    private ArrayList<Movie> movies = new ArrayList();

    public MovieCollection() {
    }

    public void addMovie(Movie newMovie){
        movies.add(newMovie);
    }

    public void deleteMovie(int index){
        movies.remove(index);
    }

    public void showCollection(){
        for(Movie movie: movies){
            System.out.println(movie.getName() + ": " + movie.getActor().getName());
        }

    }




}
