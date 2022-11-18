package movierecsys.gui.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import movierecsys.be.Movie;
import movierecsys.bll.InputValidator;
import movierecsys.bll.LogicManager;
import movierecsys.bll.OwsLogicFacade;

import java.util.List;

public class MovieModel {
    private final ObservableList<Movie> movies;
    private OwsLogicFacade bll = new LogicManager();
    private InputValidator validator = new InputValidator();

    public MovieModel(){
        movies = FXCollections.observableArrayList();
    }

    public void fetchAllMovies(){
        movies.clear();
        movies.addAll(bll.getAllMovies());
    }

    public ObservableList<Movie> getMovies() {
        return movies;
    }

    public void search(String query) {
        movies.clear();
        movies.addAll(bll.searchMovies(query));
    }

    public Movie createMovie(int year, String title) {
        Movie movie = bll.createMovie(year, title);
        movies.add(movie);
        return movie;
    }

    public void deleteMovie(Movie movie) {
        bll.deleteMovie(movie);
        movies.remove(movie);
    }

    public int getValidYear(String text) {
        return validator.getValidYear(text);
    }
}
