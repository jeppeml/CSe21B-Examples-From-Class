/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierecsys.dal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import movierecsys.be.Movie;

import static java.nio.file.StandardOpenOption.APPEND;

/**
 * @author pgn
 */
public class MovieDAO {

    private static final String MOVIE_SOURCE = "data/movie_titles.txt";

    public static void main(String[] args) {
        MovieDAO mdao = new MovieDAO();
        Movie theIncredibleHulk = mdao.getMovie(4688);
        System.out.println(theIncredibleHulk.getTitle());
        System.out.println(mdao.getNextId());
        //mdao.createMovie(1986, "Jeppe starts at primary school");
    }
    /**
     * Gets a list of all movies in the persistence storage.
     *
     * @return List of movies.
     * @throws java.io.FileNotFoundException
     */
    public List<Movie> getAllMovies() throws FileNotFoundException, IOException {
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
        if (!arrMovie[1].equals("NULL"))
            year = Integer.parseInt(arrMovie[1]);

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
        try {
            long millis = System.currentTimeMillis();
            List<Movie> movies = getAllMovies();
            int biggestId = 0;
            for(Movie m : movies){
                if(biggestId<m.getId())
                    biggestId = m.getId();
            }
            System.out.println(System.currentTimeMillis()-millis);
            return biggestId+1;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private Movie createMovie(int releaseYear, String title) {
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
    private void deleteMovie(Movie movie) {
        //TODO Delete movie
    }

    /**
     * Updates the movie in the persistence storage to reflect the values in the
     * given Movie object.
     *
     * @param movie The updated movie.
     */
    private void updateMovie(Movie movie) {
        //TODO Update movies
    }

    /**
     * Gets a the movie with the given ID.
     *
     * @param id ID of the movie.
     * @return A Movie object.
     */
    private Movie getMovie(int id) {
        /*try {
            List<Movie> movies = getAllMovies();
            for (Movie m : movies){
                if (m.getId()==id)
                    return m;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;*/


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
