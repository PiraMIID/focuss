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
        timerPaneController.setTypeBlockPane(typeBlockPaneController);


    }
}
