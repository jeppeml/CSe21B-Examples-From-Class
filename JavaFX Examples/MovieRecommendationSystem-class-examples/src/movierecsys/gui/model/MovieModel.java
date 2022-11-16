package movierecsys.gui.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import movierecsys.be.Movie;
import movierecsys.bll.LogicManager;
import movierecsys.bll.OwsLogicFacade;

public class MovieModel {
    private final ObservableList<Movie> movies;
    private OwsLogicFacade bll = new LogicManager();

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
}
