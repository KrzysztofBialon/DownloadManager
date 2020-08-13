package sample.controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import sample.gui.DownloadItemBar;
import sample.httpconnection.HTTPConnectionClass;

public class Controller {

    @FXML
    private Button startDownloadBtn;
    @FXML
    private MenuButton extensionBtn;
    @FXML
    private TextField urlInputField;

    private ObservableList<Button> downloadsItemsObservableList;

    //String fileUrl = "https://javadl.oracle.com/webapps/download/AutoDL?BundleId=242990_a4634525489241b9a9e1aa73d9e118e6";


    @FXML
    public void initialize()
    {
        startDownloadBtn.addEventHandler(MouseEvent.MOUSE_CLICKED,
                                        mouseEvent ->
                                        {
                                            try
                                            {
                                                new HTTPConnectionClass(this.urlInputField.getText(), this.extensionBtn.getText()).setConnection();
                                            } catch (Exception e)
                                            {
                                                e.printStackTrace();
                                            }
                                        });
    }



}
