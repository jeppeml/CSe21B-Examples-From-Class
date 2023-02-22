package dk.easv.test.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    public ScrollPane scrollPane;
    public HBox hb;
    @FXML
    private Label lblText;

    @FXML
    private void clickBtn(ActionEvent actionEvent) {
        lblText.setText("Weeee!");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hb.prefHeightProperty().bind(scrollPane.heightProperty());
    }
}
