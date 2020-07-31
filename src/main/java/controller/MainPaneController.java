package controller;

import javafx.fxml.FXML;

public class MainPaneController {
    @FXML
    private SettingsPlotPaneController settingsPlotPaneController;
    @FXML
    private TimerPaneController timerPaneController;
    @FXML
    private TypeBlockPaneController typeBlockPaneController;

    public void initialize() {
        System.out.println("siena");
        System.out.println(timerPaneController);
        System.out.println(settingsPlotPaneController);
        System.out.println(typeBlockPaneController);





    }

    private void createTimer() {



    }
}
