package dk.easv.test.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
    @FXML
    private Label lblText;

    @FXML
    private void clickBtn(ActionEvent actionEvent) {
        lblText.setText("Weeee!");
    }
}
