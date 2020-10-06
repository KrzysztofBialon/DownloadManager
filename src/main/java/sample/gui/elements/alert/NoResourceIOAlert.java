package sample.gui.elements.alert;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class NoResourceIOAlert extends Alert
{
    public NoResourceIOAlert( ButtonType... buttonTypes) {
        super(AlertType.ERROR, "No resource!", buttonTypes);

        this.setContentText("There is no files to download under given URL. Check URL.");
    }
}
