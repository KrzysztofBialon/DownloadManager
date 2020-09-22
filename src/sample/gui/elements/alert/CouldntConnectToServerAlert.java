package sample.gui.elements.alert;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class CouldntConnectToServerAlert extends Alert
{
    public CouldntConnectToServerAlert ( ButtonType... buttonTypes) {
        super(Alert.AlertType.ERROR, "Connection error", buttonTypes);

        this.setContentText("Couldn't connect to the server!");
    }
}
