package controller;


import com.opencsv.CSVWriter;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.util.Duration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class TimerPaneController {


    @FXML
    private Label targetTimeLagel;
    @FXML
    private TextField timeInputField;
    @FXML
    private Label timerLabel;
    @FXML
    private Button startStopButton;
    @FXML
    private Button doneButton;
    @FXML
    private Button resetButton;

    private TypeBlockPaneController typeBlockPane;

    public void setTypeBlockPane(TypeBlockPaneController typeBlockPane) {
        this.typeBlockPane = typeBlockPane;
    }

    public Label getTargetTimeLagel() {
        return targetTimeLagel;
    }

    public TextField getTimeInputField() {
        return timeInputField;
    }

    public Label getTimerLabel() {
        return timerLabel;
    }

    public Button getStartStopButton() {
        return startStopButton;
    }

    private int mins = 0, secs = 55, hours = 0;

    private boolean startStopButtonState = false;
    private Integer maxLeght = 4;
    boolean finishBlock = false;

    public TimerPaneController() {
    }

    public void initialize() {
        System.out.println("esa");
        System.out.println(startStopButtonState);
        startStopButton.setText("Start");
        timeInputField.setText("elo");
        System.out.println(timeInputField.getText());
        configureInput();
        initButton();
        timeline.setAutoReverse(false);
        timeline.setCycleCount(timeline.INDEFINITE);
    }

    public void configureInput() {
        timeInputField.setText("");
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

            System.out.println(hours + ":" + mins + ":" + secs);
            String name = hours + ":" + mins + ":" + secs++;
            timerLabel.setText(name);


            if ((mins + hours * 60) == checkInput()){
                doneButton.fire();
                finishBlock = true;
                resetButton.fire();
            }

        }
    }));


    private void initButton() {
        startStopButton.setStyle("-fx-background-color: seagreen");
        startStopButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println(startStopButtonState);


                if (startStopButtonState) {
                    startStopButton.setText("Start");
                    timeline.stop();
                    startStopButtonState = false;
                    startStopButton.setStyle("-fx-background-color: seagreen");

                } else {

                    if (!(timeInputField.getText().length() == 0 || typeBlockPane.getTypeStudyChoiceBox().getValue()==null || typeBlockPane.getUserChoiceBox() == null)) {
                        checkInput();
                        targetTimeLagel.setText(inputToLable(checkInput()));
                        startStopButton.setText("Stop");
                        timeline.play();
                        startStopButtonState = true;
                        startStopButton.setStyle("-fx-background-color: indianred");
                    }
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




    public void reset(ActionEvent actionEvent) {
        startStopButton.setText("Start");
        timeline.stop();
        startStopButtonState = false;
        startStopButton.setStyle("-fx-background-color: seagreen");


        if (!finishBlock) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setContentText("Czy napewno chceż zrestartować ?");
            alert.setHeaderText(null);
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {
                secs = 1;
                mins = 0;
                hours = 0;
                timerLabel.setText("0:0:0");
                timeInputField.clear();
            }
        } else {
            doneButton.fire();
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setContentText("Skończył sie zaplanowany czas nauki. Zapisano");
            alert.setHeaderText(null);
            finishBlock = false;
            secs = 1;
            mins = 0;
            hours = 0;
            timerLabel.setText("0:0:0");
            alert.show();
        }



    }

    public void doneBlock(ActionEvent actionEvent) {
        String user = typeBlockPane.getUserChoiceBox().getValue();
        String typeStudy = typeBlockPane.getTypeStudyChoiceBox().getValue();
        timeline.stop();
        File file = new File("src\\main\\resources\\csv\\history\\" + user + ".csv");
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            CSVWriter writer = new CSVWriter(fileWriter);
            String[] data = {typeStudy , LocalDate.now().toString(), hours + ":" + mins};
            writer.writeNext(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        startStopButton.setText("Start");
        startStopButtonState = false;
        startStopButton.setStyle("-fx-background-color: seagreen");

        timeInputField.clear();




    public void doneBlock(ActionEvent actionEvent) {
    }


    }
}

