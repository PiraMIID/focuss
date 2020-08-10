module focus {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;


    exports main to javafx.graphics, javafx.controls, javafx.fxml,javafx.base;
    opens controller to javafx.graphics, javafx.controls, javafx.fxml;

}