package controller;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class PaneController {
    @FXML
    private Button resetButton;

    @FXML
    private Label timerLabel;

    @FXML
    private Button startStopButton;

    private int mins = 0, secs = 0, hours = 0;
    private boolean timeDone;
    private boolean startStopButtonState = false;


    public void initialize() {
        System.out.println("esa");
        startStopButton.setText("Start");
        initTime();
        initButton();
        timeline.setAutoReverse(false);
        timeline.setCycleCount(timeline.INDEFINITE);


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
                if (startStopButtonState == true) {
                    startStopButton.setText("Start");
                    timeline.stop();
                    startStopButtonState = false;
                }
                 else if (startStopButtonState == false) {
                    startStopButton.setText("Stop");
                    timeline.play();
                    startStopButtonState = true;
                }
            }
        });
    }

    private void initTime() {
        timeDone = true;

    }


    public void reset(ActionEvent actionEvent) {
        timeline.stop();


    }


}

