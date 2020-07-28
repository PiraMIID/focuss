module focus {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires spring.core;


    exports main to javafx.graphics, javafx.controls, javafx.fxml, spring.core,javafx.base;
    opens controller to javafx.graphics, javafx.controls, javafx.fxml;

}