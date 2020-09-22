package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sample.logic.event.DownloadButtonEvent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

    private final ExecutorService downloadUserActionThreadPool = Executors.newFixedThreadPool(2);

    @FXML
    public void initialize() {
        contentWrapper.setMaxSize(800, 800);
        topBarContainer.prefWidthProperty().bind(contentWrapper.widthProperty());
        //Initialize extension box with ext list
        extensionSelectionBox.getItems().setAll(extensionList);
        extensionSelectionBox.setValue(extensionList.get(0));
        //Add functionality to startDownload button
        //TODO if waiting too long for download cancel, check time waiting for connection
        startDownloadBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new DownloadButtonEvent(
                urlInputField,
                extensionSelectionBox,
                downloadListWrapper,
                downloadUserActionThreadPool));
    }


}
