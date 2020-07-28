package main;

import controller.PaneController;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.regex.Pattern;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        Pane mainBox = FXMLLoader.load(getClass().getResource("/fxml/focus.fxml"));
        Scene scene = new Scene(mainBox);
        stage.setScene(scene);
        stage.setTitle("Focus");
        stage.show();


//        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
//            int mins = 0;
//            int secs =  1 ;
//            int hours = 0;
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                if (secs == 60.0) {
//                    mins++;
//                    secs = 0;
//                }
//                if (mins == 60) {
//                    hours++;
//                    mins = 0;
//                }
//                System.out.println(hours + ":" + mins + ":" + secs);
//                String name = hours + ":" + mins + ":" + secs;
//                timerLabel.setText(name);
//
//            }}));




//        timeline.play();


//        Timelines musi być zawarte tutaj w tej klasie.






    }
}


//if (secs == 60) {
//        mins++;
//        secs=0;
//        }
//        if (mins == 60) {
//        hours++;
//        mins=0;
//        }
//        timerLabel.setText(hours +":"+mins+":"+secs);