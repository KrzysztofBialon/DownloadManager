package sample.gui.elements.alert;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class ProtocolAlert extends Alert
{
    public ProtocolAlert( ButtonType... buttonTypes) {
        super(AlertType.ERROR, "Protocol error", buttonTypes);

        this.setContentText("A protocol error occured.");
    }
}
