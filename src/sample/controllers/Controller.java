package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sample.CustomMouseEvent;

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
        startDownloadBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new CustomMouseEvent(
                urlInputField,
                extensionSelectionBox,
                downloadListWrapper,
                downloadUserActionThreadPool));
                /*mouseEvent ->
                {
                    //Create URL if malformed inform user and quit method
                    URL url;
                    try {
                        url = new URL(urlInputField.getText());
                    } catch (MalformedURLException e) {
                        urlInputField.setStyle("-fx-border-color: red");
                        return;
                    }

                    String extension = extensionSelectionBox.getValue().toString();

                    Thread downloadAction = new Thread(DownloadActionLogicThread.
                            downloadActionThread(url, extension, downloadListWrapper));

                    downloadUserActionThreadPool.execute(downloadAction);
                });*/
    }


}
