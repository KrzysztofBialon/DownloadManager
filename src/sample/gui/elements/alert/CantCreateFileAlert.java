package sample.gui.elements.alert;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class CantCreateFileAlert extends Alert
{
    public CantCreateFileAlert( ButtonType... buttonTypes) {
        super(AlertType.ERROR, "File error", buttonTypes);

        this.setContentText("Can't create a file.");
    }
}
