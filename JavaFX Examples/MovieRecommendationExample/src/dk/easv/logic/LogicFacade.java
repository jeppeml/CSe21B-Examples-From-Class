package dk.easv.logic;

import dk.easv.entities.Movie;
import dk.easv.entities.TopMovie;
import dk.easv.entities.User;
import dk.easv.entities.UserSimilarity;

import java.util.Collection;
import java.util.List;

public interface LogicFacade {
    void reloadAllDataFromStorage();

    Collection<User> getAllUsers();

    // Gets all rated movies for one user and returns them sorted by avg. best by all users.
    List<Movie> getTopAverageRatedMovies(User u);

    // Gets all rated movies for one user and returns them sorted by avg. best by all users.
    List<Movie> getTopAverageRatedMoviesUserDidNotSee(User u);

    List<UserSimilarity> getTopSimilarUsers(User user);

    List<TopMovie> getTopMoviesFromSimilarPeople(User u);
}
