/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierecsys.dal;

import movierecsys.be.Movie;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.StandardOpenOption.APPEND;

/**
 * @author pgn
 */
public class MovieDAO {

    private static final String MOVIE_SOURCE = "data/movie_titles.txt";

    /**
     * Gets a list of all movies in the persistence storage.
     *
     * @return List of movies.
     */
    public List<Movie> getAllMovies() {
        List<Movie> allMovies = new ArrayList<>();
        File file = new File(MOVIE_SOURCE);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {

                    Movie mov = stringArrayToMovie(line);
                    allMovies.add(mov);
                } catch (Exception ex) {
                    //Do nothing we simply do not accept malformed lines of data.
                    //In a perfect world you should at least log the incident.
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return allMovies;
    }

    /**
     * Reads a movie from a , s
     *
     * @param t
     * @return
     * @throws NumberFormatException
     */
    private Movie stringArrayToMovie(String t) {
        String[] arrMovie = t.split(",");

        int id = Integer.parseInt(arrMovie[0]);
        int year = 0;
        try{
            year = Integer.parseInt(arrMovie[1]);
        }
        catch (NumberFormatException nfe){
            year = -1;
        }

        String title = arrMovie[2];
        if (arrMovie.length > 3) {
            for (int i = 3; i < arrMovie.length; i++) {
                title += "," + arrMovie[i];
            }
        }
        Movie mov = new Movie(id, year, title);

        return mov;

    }

    private int getNextId(){

            List<Movie> movies = getAllMovies();
            int biggestId = 0;
            for(Movie m : movies){
                if(biggestId<m.getId())
                    biggestId = m.getId();
            }
            return biggestId+1;


    }
    public Movie createMovie(int releaseYear, String title) {
        int id = getNextId();
        try {
            Files.writeString(
                    Path.of(MOVIE_SOURCE),
                    id + "," + releaseYear + "," + title + "\n",
                    APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new Movie(id, releaseYear,title);
    }

    /**
     * Deletes a movie from the persistence storage.
     *
     * @param movie The movie to delete.
     */
    public void deleteMovie(Movie movie) {
        try {
            List<Movie> movies = getAllMovies();

            String movieString  = "";
            for(Movie m : movies){
                if(m.getId()!=movie.getId()){
                    movieString += m.getId() + "," +
                            m.getYear() + "," +
                            m.getTitle() + "\n";
                }
            }
            Files.writeString(Path.of(MOVIE_SOURCE),movieString);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Updates the movie in the persistent storage to reflect the values in the
     * given Movie object.
     *
     * @param movie The updated movie.
     */
    public void updateMovie(Movie movie) {
        try {
            List<Movie> movies = getAllMovies();

            String movieString  = "";
            for(Movie m : movies){
                if(m.getId()==movie.getId()){
                    m = movie;
                }
                movieString += m.getId() + "," +
                        m.getYear() + "," +
                        m.getTitle() + "\n";
            }

            Files.writeString(Path.of(MOVIE_SOURCE),movieString);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Gets a movie with the given ID.
     *
     * @param id ID of the movie.
     * @return A Movie object.
     */
    public Movie getMovie(int id) {
        try {
            List<String> lines = Files.readAllLines(Path.of(MOVIE_SOURCE));
            for(String line : lines ){
                if(line!=null) {
                    Movie currentMovie = stringArrayToMovie(line);
                    if (currentMovie.getId() == id) {
                        return currentMovie;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
