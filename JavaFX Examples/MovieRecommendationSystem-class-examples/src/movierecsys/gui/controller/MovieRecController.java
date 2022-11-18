/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierecsys.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import movierecsys.be.Movie;
import movierecsys.gui.model.MovieModel;

/**
 *
 * @author pgn
 */
public class MovieRecController implements Initializable
{
    @FXML
    private TextField txtTitle;
    @FXML
    private TextField txtMovieSearch;
    @FXML
    private TextField txtYear;
    @FXML
    private ListView<Movie> lstMovies;

    MovieModel model = new MovieModel();

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        lstMovies.setItems(model.getMovies());
        model.fetchAllMovies();
        txtMovieSearch.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                model.search(newValue);
            }
        });
    }

    public void clickCreate(ActionEvent actionEvent) {
        model.createMovie(Integer.parseInt(txtYear.getText()),txtTitle.getText());
        txtYear.clear();
        txtTitle.clear();
    }

    public void clickDelete(ActionEvent actionEvent) {
        Movie selectedMovie = lstMovies.getSelectionModel().getSelectedItem();
        model.deleteMovie(selectedMovie);
    }
}