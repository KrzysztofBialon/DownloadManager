package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import sample.gui.DownloadItemBar;
import sample.httpconnection.HTTPConnectionClass;

import java.util.Arrays;
import java.util.List;

public class Controller {

    @FXML
    private Button startDownloadBtn;
    @FXML
    private TextField urlInputField;
    @FXML
    private VBox downloadListWrapper;
    @FXML
    private ComboBox extensionSelectionBox;

    private final List<String> extensionList = Arrays.asList("exe", "zip", "pdf", "txt", "mp3", "mp4");

    @FXML
    public void initialize()
    {
        //Initialize extension box with ext list
        extensionSelectionBox.getItems().setAll(extensionList);
        extensionSelectionBox.setValue(extensionList.get(0));
        //Add functionality to startDownload button
        startDownloadBtn.addEventHandler(MouseEvent.MOUSE_CLICKED,
                                        mouseEvent ->
                                        {

                                            try
                                            {
                                                new HTTPConnectionClass(this.urlInputField.getText(), this.extensionSelectionBox.getValue().toString()).setConnection();
                                            } catch (Exception e)
                                            {
                                                e.printStackTrace();
                                            }
                                        });

        downloadListWrapper.getChildren().add(new DownloadItemBar("test", 10000).getWrapper());

    }



}
