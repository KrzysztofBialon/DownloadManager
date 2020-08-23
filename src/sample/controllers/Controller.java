package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sample.DownloadActionBuilder;
import sample.TaskBuilder;
import sample.DownloadPoolManager;
import sample.FileDetailsClass;
import sample.gui.elements.DownloadItemBar;
import sample.httpconnection.HTTPConnectionClass;

import java.util.Arrays;
import java.util.List;

public class Controller {

    @FXML
    private BorderPane contentWrapper;
    @FXML
    private HBox topBarContainer;
    @FXML
    private Button startDownloadBtn;
    @FXML
    private TextField urlInputField;
    @FXML
    private VBox downloadListWrapper;
    @FXML
    private ComboBox extensionSelectionBox;

    private final List<String> extensionList = Arrays.asList("exe", "zip", "pdf", "txt", "mp3", "mp4");
    private DownloadPoolManager downloadPoolManager = new DownloadPoolManager();
    @FXML
    public void initialize()
    {
        contentWrapper.setMaxSize(800, 800);

        topBarContainer.prefWidthProperty().bind(contentWrapper.widthProperty());
        //Initialize extension box with ext list
        extensionSelectionBox.getItems().setAll(extensionList);
        extensionSelectionBox.setValue(extensionList.get(0));
        //Add functionality to startDownload button
        startDownloadBtn.addEventHandler(MouseEvent.MOUSE_CLICKED,
                                        mouseEvent ->
                                        {
                                            try {
                                                /*FileDetailsClass fileDetailsClass = HTTPConnectionClass.
                                                        setConnection(urlInputField.getText(),
                                                        extensionSelectionBox.
                                                                getValue().
                                                                toString());
                                                DownloadPoolManager.
                                                        addDownloadToPool(
                                                            TaskBuilder.createSaveFileClass(fileDetailsClass));
                                                DownloadItemBar bar = new DownloadItemBar(
                                                        fileDetailsClass.getFileHeaderName(),
                                                        fileDetailsClass.getFileSize());
                                                downloadListWrapper.getChildren().add(bar.getWrapper());*/

                                                DownloadActionBuilder actionBuilder = new DownloadActionBuilder();

                                                actionBuilder.build(urlInputField.getText(),
                                                        extensionSelectionBox.
                                                                getValue().
                                                                toString());
                                                
                                                downloadListWrapper.
                                                        getChildren().
                                                        add(actionBuilder.
                                                                getBar().
                                                                getWrapper());
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        });
    }



}
