package sample.controllers;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sample.logic.paused.GetAllPausedBars;
import sample.logic.paused.InitializePausedDownloadObjects;
import sample.logic.event.DownloadButtonEvent;
import sample.logic.files.crud.ReadPauseFileDetails;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

    private final ExecutorService downloadThreadPool = Executors.newFixedThreadPool(2);

    @FXML
    public void initialize() throws IOException
    {
        //Initialize extension box with ext list
        extensionSelectionBox.getItems().setAll(extensionList);
        extensionSelectionBox.setValue(extensionList.get(0));
        //Add functionality to startDownload button
        startDownloadBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new DownloadButtonEvent(
                urlInputField,
                extensionSelectionBox,
                downloadListWrapper,
                downloadThreadPool));
        //initialize download list with paused files
        downloadListWrapper.
                getChildren().
                addAll(
                        GetAllPausedBars.
                                getBars(
                                        InitializePausedDownloadObjects.
                                                loadPausedFiles(
                                                        ReadPauseFileDetails.
                                                                readPausedFilesFromFile(),
                                                                downloadThreadPool,
                                                                downloadListWrapper)));
    }
}
