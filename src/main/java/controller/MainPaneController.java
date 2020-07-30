package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainPaneController {
    @FXML
    private VBox inPutPane;
    @FXML
    private TimerController timerController;
    @FXML
    private HBox settingsPlotPane;

    public void initialize() {
        System.out.println(timerController);

    }

    private void createTimer() {



    }
}
