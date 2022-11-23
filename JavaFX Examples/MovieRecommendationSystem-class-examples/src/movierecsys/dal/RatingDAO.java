/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierecsys.dal;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import movierecsys.be.Movie;
import movierecsys.be.MovieAverageRating;
import movierecsys.be.Rating;
import movierecsys.be.User;

/**
 *
 * @author pgn
 */
public class RatingDAO
{
    private static final String RATING_SOURCE = "data/ratings.txt";
    private MovieDAO movieDAO = new MovieDAO();
    private HashMap<Integer, Movie> movies = new HashMap<>();

    private UserDAO userDAO = new UserDAO();
    private HashMap<Integer, User> users = new HashMap<>();
    public static void main(String[] args) {
        RatingDAO dao = new RatingDAO();
        long start = System.currentTimeMillis();
        System.out.println("Starting...");
        List<Rating> ratings = dao.getAllRatings();
        //System.out.println(dao.getAllRatings());
        System.out.println("finished");
        System.out.println(System.currentTimeMillis()-start);

        HashMap<Movie, MovieAverageRating> mavg = new HashMap<>();

        List<MovieAverageRating> movieAvg = new ArrayList();
        System.out.println("Start ratings count");
        for(Rating r : ratings){
            Movie m = r.getMovie();
            if(movieAvg.contains(r.getMovie())){
                MovieAverageRating mar = movieAvg.get(movieAvg.indexOf(m));
                mar.setTotal(mar.getTotal()+r.getRating());
                mar.setAmount(mar.getAmount()+1);
            }
            else {
                movieAvg.add(new MovieAverageRating(m, r.getRating(),1));
            }
        }
        System.out.println("Stop ratings count and sort start...");
        movieAvg.sort((m1,m2)->m1.getAverageRating()-m2.getAverageRating());

        System.out.println(movieAvg.get(0));

    }

    public RatingDAO(){
        List<Movie> moviesList = movieDAO.getAllMovies();
        List<User> usersList = userDAO.getAllUsers();
        for (Movie m : moviesList)
            movies.put(m.getId(), m);

        for (User u : usersList)
            users.put(u.getId(),u);
    }

    /**
     * Persists the given rating.
     * @param rating the rating to persist.
     */
    public void createRating(Rating rating)
    {
        //TODO Rate movie
    }
    
    /**
     * Updates the rating to reflect the given object.
     * @param rating The updated rating to persist.
     */
    public void updateRating(Rating rating)
    {
        //TODO Update rating
    }
    
    /**
     * Removes the given rating.
     * @param rating 
     */
    public void deleteRating(Rating rating)
    {
        //TODO Delete rating
    }
    
    /**
     * Gets all ratings from all users.
     * @return List of all ratings.
     */
    public List<Rating> getAllRatings()
    {
        List<Rating> allRatings = new ArrayList<>();
        File file = new File(RATING_SOURCE);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {

                    Rating rating = stringToRating(line);
                    allRatings.add(rating);
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
        return allRatings;
    }

    private Rating stringToRating(String t) {
        String[] arrUser = t.split(",");

        int movieId = Integer.parseInt(arrUser[0]);
        int userId = Integer.parseInt(arrUser[1]);
        int rating = Integer.parseInt(arrUser[2]);

        return new Rating(movies.get(movieId),users.get(userId),rating);
    }

    /**
     * Get all ratings from a specific user.
     * @param user The user 
     * @return The list of ratings.
     */
    public List<Rating> getRatings(User user)
    {
        //TODO Get user ratings.
        return null;
    }
    
}
