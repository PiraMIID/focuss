package controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

import java.util.ArrayList;
import java.util.List;

public class ParamsBlockControler extends TimerController {

    @FXML
    private ChoiceBox userChoiceBox;

    private List<String> userList = new ArrayList<>();




    @Override
    public void initialize() {
        super.initialize();
        userList.add("first");
        userList.add("second");
        System.out.println("asse");
        userChoiceBox.setItems((ObservableList) userList);
    }
}
