package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        Pane mainBox = FXMLLoader.load(getClass().getResource("/fxml/mainPane.fxml"));
        Scene scene = new Scene(mainBox);
        stage.setScene(scene);
        stage.setTitle("Focus");
        stage.show();



    }

//    private Parent replaceSceneContent(String fxml) throws Exception {
//            Parent page = (Parent) FXMLLoader.load(App.class.getResource(fxml), null, new JavaFXBuilderFactory());
//            Scene scene = stage.getScene();
//            if (scene == null) {
//                scene = new Scene(page, 700, 450);
//                scene.getStylesheets().add(App.class.getResource("demo.css").toExternalForm());
//                stage.setScene(scene);
//            } else {
//                stage.getScene().setRoot(page);
//            }
//            stage.sizeToScene();
//            return page;
//        }

}


