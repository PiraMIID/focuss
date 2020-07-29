package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainPaneControler {



    @FXML
    private Button settingsButton;

    @FXML
    private Button plotBotton;

    @FXML
    private ChoiceBox<String> userChoiceBox;

    @FXML
    private ChoiceBox<String> typeStudyChoiceBox;

    @FXML
    private TextField timeInputField;

    @FXML
    private Label targetTimeLagel;

    @FXML
    private Label timerLabel;

    @FXML
    private Button doneButton;

    @FXML
    private Button startStopButton;

    @FXML
    private Button resetButton;


    @FXML
    void doneBlock(ActionEvent event) {

    }

    @FXML
    void reset(ActionEvent event) {

    }
}
