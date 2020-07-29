package controller;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class PaneController {

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
                System.out.println(startStopButtonState);


                if (startStopButtonState) {
                    startStopButton.setText("Start");
                    timeline.stop();
                    startStopButtonState = false;
                }
                 else  {
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
        int m = inputInt%60;
        int h = (inputInt - m) /60;
        String text = h + ":" + m + ":0";
        return text;
    }

    private void initTime() {
        timeDone = true;

    }


    public void reset(ActionEvent actionEvent) {
        timeline.stop();
        secs = 1;
        mins = 0;
        hours = 0;
        timerLabel.setText("0:0:0");
        startStopButton.setText("start");
        startStopButtonState = false;
    }




}

