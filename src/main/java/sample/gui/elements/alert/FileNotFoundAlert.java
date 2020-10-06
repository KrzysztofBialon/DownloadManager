package sample.gui.elements.alert;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class FileNotFoundAlert extends Alert
{
    public FileNotFoundAlert( ButtonType... buttonTypes) {
        super(Alert.AlertType.ERROR, "File not found", buttonTypes);

        this.setContentText("File with given name can't be found.");
    }
}
