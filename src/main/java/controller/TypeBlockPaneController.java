package controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TypeBlockPaneController {

    private static TypeBlockPaneController INSTANCE;

    public TypeBlockPaneController() {
        System.out.println(INSTANCE);

    }

    public static TypeBlockPaneController getInstance() {
        if (INSTANCE != null) {
            return INSTANCE;
        }
        return new TypeBlockPaneController();
    }

    @FXML
    private ChoiceBox<String> userChoiceBox;

    @FXML
    private ChoiceBox<String> typeStudyChoiceBox;

    @FXML
    private Button addUserButton;

    Set<String> listOfTypeStudy;
    Set<String> userList = new HashSet<>();



    public ChoiceBox<String> getUserChoiceBox() {
        return userChoiceBox;
    }

    public ChoiceBox<String> getTypeStudyChoiceBox() {
        return typeStudyChoiceBox;
    }

    public void initialize() {
        INSTANCE = new TypeBlockPaneController();
        getInstance();
        initButton();
        initCheckBoxes();


    }

    private void initCheckBoxes() {
        File f = new File("src\\main\\resources\\csv\\users");
        String[] usersCsv = f.list();
        for (String userName : usersCsv) {
            userList.add(userName.substring(0, userName.length()-4));
            userChoiceBox.getItems().setAll(userList);
        }
        userChoiceBox.setOnAction(actionEvent -> {
            listOfTypeStudy = new HashSet<>();
            if (userChoiceBox.getValue()!=null) {
                try (Scanner csvText = new Scanner(new File("src\\main\\resources\\csv\\users\\" + userChoiceBox.getValue() + ".csv"))){

                    while (csvText.hasNextLine()) {
                        String line = csvText.nextLine();
                        String[] split = line.split(";");
                        listOfTypeStudy.add(split[0]);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }

            typeStudyChoiceBox.getItems().setAll(listOfTypeStudy);
        });


    }

    public void addTypeStudy(ActionEvent actionEvent) {
        VBox addTypeStudyLayout = new VBox();

        TextField nameNewTypeStudyInput = new TextField();
        Button confirmButton = new Button("    Dodaj Rodzaj nauki    ");


        addTypeStudyLayout.getChildren().add(nameNewTypeStudyInput);
        addTypeStudyLayout.getChildren().add(confirmButton);

        Scene addUserScene = new Scene(addTypeStudyLayout);
        Stage newWindow = new Stage();

        newWindow.setScene(addUserScene);
        newWindow.setResizable(false);

        newWindow.show();

        confirmButton.setOnAction(action -> {
            System.out.println(nameNewTypeStudyInput.getText());
            listOfTypeStudy.add(nameNewTypeStudyInput.getText());

            newWindow.close();

            typeStudyChoiceBox.getItems().setAll(listOfTypeStudy);

            System.out.println(listOfTypeStudy);
        });


    }



    private void initButton() {
        addUserButton.setOnAction(actionEvent -> {
            System.out.println("kicha");

            VBox addUserLayout = new VBox();

            TextField nameNewUserInput = new TextField();
            Button confirmButton = new Button("    Dodaj Użytkowanika    ");


            addUserLayout.getChildren().add(nameNewUserInput);
            addUserLayout.getChildren().add(confirmButton);

            Scene addUserScene = new Scene(addUserLayout);
            Stage newWindow = new Stage();
            newWindow.setTitle("Dodaj nowego użytkownika");
            newWindow.setScene(addUserScene);
            newWindow.setResizable(false);

            newWindow.show();
            //add new User
            confirmButton.setOnAction(actionEvent1 -> {
                System.out.println(nameNewUserInput.getText());
                String filename = "src\\main\\resources\\csv\\users\\"+nameNewUserInput.getText()+".csv";
                File file = new File(filename);
                System.out.println(file.getAbsolutePath());
                FileWriter fileWriter = null;
                try {
                    fileWriter = new FileWriter(file);
                } catch (IOException e) {
                    Alert.AlertType alertAlertType;
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setTitle("Użytkownik nie został utworzony");
                }

                newWindow.close();


            });
        });
    }


}
