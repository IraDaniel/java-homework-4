package com.company.task4;

import java.io.*;

/**
 * Created by Ira on 09.01.2016.
 */
public class MovieCollectionSerialization {
    public static void main(String[] args) {
        Actor actor1 = new Actor("Brad Pitt");
        Actor actor2 = new Actor("DiCaprio");
        Movie movie1 = new Movie("Titanic",actor2);
        Movie movie2 = new Movie("Inception",actor2);
        Movie movie3 = new Movie("M&M Smitt",actor1);

        MovieCollection movieCollection = new MovieCollection();
        movieCollection.addMovie(movie1);
        movieCollection.addMovie(movie2);
        movieCollection.addMovie(movie3);

     //  movieCollection.deleteMovie(1);

        movieCollection.showCollection();
        String fileName = "serialize.txt";

        try {

            FileOutputStream os = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(movieCollection);
            oos.close();
            os.close();

            System.out.println("Read objects:");

            FileInputStream is = new FileInputStream(fileName);

            ObjectInputStream ois = new ObjectInputStream(is);

            while (is.available() > 0) {
                MovieCollection movieCollection1 = (MovieCollection)ois.readObject();
                movieCollection1.showCollection();
            }

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }


    }
}
