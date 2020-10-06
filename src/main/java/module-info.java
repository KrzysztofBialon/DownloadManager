module downloadManager {

    requires javafx.fxml;
    requires javafx.controls;
    requires org.apache.commons.io;
    exports sample.controllers;

    opens sample;
    opens sample.controllers to javafx.fxml;
}