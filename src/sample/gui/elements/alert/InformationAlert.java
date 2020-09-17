package sample.gui.elements.alert;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class InformationAlert extends Alert{

    public InformationAlert(String title, String contentText , ButtonType... buttonTypes)
    {
        super(AlertType.ERROR, title, buttonTypes);

        this.setTitle(title);
        this.setContentText(contentText);
    }
}
