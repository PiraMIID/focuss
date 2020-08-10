package controller;

import javafx.fxml.FXML;

public class MainPaneController {
    @FXML
    private SettingsPlotPaneController settingsPlotPaneController;
    @FXML
    private TimerPaneController timerPaneController;
    @FXML
    private TypeBlockPaneController typeBlockPaneController;

    public TypeBlockPaneController getTypeBlockPaneController() {
        return typeBlockPaneController;
    }

    public void initialize() {
        System.out.println("siena");
        System.out.println(timerPaneController);
        System.out.println(settingsPlotPaneController);
        System.out.println(typeBlockPaneController.getUserChoiceBox());
        initSave();





    }

    private void initSave() {

    }

    private void createTimer() {



    }
}
