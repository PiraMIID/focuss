package controller;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Optional;

public class TimerController {


    @FXML
    private Label targetTimeLagel;

    @FXML
    private TextField timeInputField;

    @FXML
    private Label timerLabel;

    @FXML
    private Button startStopButton;

    private int mins = 0, secs = 1, hours = 0;
    private boolean timeDone;
    private boolean startStopButtonState = false;
    private Integer maxLeght = 4;


    public void initialize() {
        System.out.println("esa");
        startStopButton.setText("Start");
        configureInput();
        initTime();
        initButton();
        timeline.setAutoReverse(false);
        timeline.setCycleCount(timeline.INDEFINITE);


    }

    private void configureInput() {
        timeInputField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {


                if (timeInputField.getLength() >= maxLeght) {
                    System.out.println(newValue);
                    System.out.println(oldValue);
                    timeInputField.setText(oldValue);
                } else if (!newValue.matches("\\d+")) {
                    System.out.println(timeInputField.getLength() >= maxLeght);
                    System.out.println(!newValue.matches("\\d+"));
                    timeInputField.setText(newValue.replaceAll("[^\\d]", ""));
                }
                if (timeInputField.getLength() != 0) {
                    targetTimeLagel.setText(inputToLable(checkInput()));
                } else {
                    targetTimeLagel.setText("0:0:0");
                }

            }
        });
    }

    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            if (secs == 60.0) {
                mins++;
                secs = 0;
            }
            if (mins == 60) {
                hours++;
                mins = 0;
            }
            if (startStopButtonState == true) {
                System.out.println(hours + ":" + mins + ":" + secs);
                String name = hours + ":" + mins + ":" + secs++;
                timerLabel.setText(name);

            }
        }
    }));


    private void initButton() {
        startStopButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println(startStopButtonState);


                if (startStopButtonState) {
                    startStopButton.setText("Start");
                    timeline.stop();
                    startStopButtonState = false;
                } else {
                    checkInput();
                    targetTimeLagel.setText(inputToLable(checkInput()));
                    startStopButton.setText("Stop");
                    timeline.play();
                    startStopButtonState = true;
                }
            }
        });


    }

    private int checkInput() {
        String text = timeInputField.getText();

        try {
            int targetTime = Integer.parseInt(text);
            return targetTime;

        } catch (NumberFormatException e) {
            timeInputField.clear();
            return 0;
        }


    }

    private String inputToLable(int inputInt) {
        int m = inputInt % 60;
        int h = (inputInt - m) / 60;
        String text = h + ":" + m + ":0";
        return text;
    }

    private void initTime() {
        timeDone = true;

    }


    public void reset(ActionEvent actionEvent) {

        startStopButton.setText("Start");
        timeline.stop();
        startStopButtonState = false;

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText("Czy napewno chceż zrestartować ?");

        Optional<ButtonType> result = alert.showAndWait();


        if (result.get() == ButtonType.OK) {
            secs = 1;
            mins = 0;
            hours = 0;
            timerLabel.setText("0:0:0");


        }





    }


    public void doneBlock(ActionEvent actionEvent) {


    }
}

