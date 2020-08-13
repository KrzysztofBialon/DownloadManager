module downloadManager {

    requires javafx.fxml;
    requires javafx.controls;
    exports sample.controllers;

    opens sample;
    opens sample.controllers to javafx.fxml;
}