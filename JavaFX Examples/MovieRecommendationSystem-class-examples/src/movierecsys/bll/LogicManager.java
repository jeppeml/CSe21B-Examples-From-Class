package movierecsys.bll;

import movierecsys.be.Movie;
import movierecsys.be.Rating;
import movierecsys.be.User;
import movierecsys.dal.MovieDAO;

import java.util.ArrayList;
import java.util.List;

public class LogicManager implements OwsLogicFacade{

    private MovieDAO movieDAO = new MovieDAO();

    @Override
    public List<Rating> getRecommendedMovies(User user) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public List<Movie> getAllTimeTopRatedMovies() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public List<Movie> getMovieReccomendations(User user) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public List<Movie> searchMovies(String query) {
        List<Movie> movies = movieDAO.getAllMovies();
        List<Movie> filtered = new ArrayList<>();

        for(Movie m: movies){
            if(m.getTitle().toLowerCase().contains(query.toLowerCase()) ||
               (""+m.getYear()).contains(query))
                filtered.add(m);

        }
        return filtered;
    }

    @Override
    public Movie createMovie(int year, String title) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void updateMovie(Movie movie) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void deleteMovie(Movie movie) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void rateMovie(Movie movie, User user, int rating) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public User createNewUser(String name) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public User getUserById(int id) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public List<User> getAllUsers() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieDAO.getAllMovies();
    }
}
