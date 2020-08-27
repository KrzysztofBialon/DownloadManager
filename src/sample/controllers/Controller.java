package sample.controllers;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sample.DownloadActionBuilder;
import sample.FileDetailsBuilder;
import sample.FileDetailsClass;
import sample.FileDetailsDirector;
import sample.download.SaveFileFromURL;
import sample.gui.elements.DownloadItemBar;
import sample.httpconnection.HTTPConnectionClass;

import java.net.URL;
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
    private ExecutorService downloadPool = Executors.newFixedThreadPool(5);

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

                                                URL url = new URL(urlInputField.getText());
                                                String extension =  extensionSelectionBox.getValue().toString();

                                                FileDetailsBuilder fileDetailsBuilder = new FileDetailsBuilder(url, extension);
                                                FileDetailsDirector fileDetailsDirector = new FileDetailsDirector(fileDetailsBuilder);
                                                fileDetailsDirector.constructFileDetails();

                                                downloadPool.execute(fileDetailsDirector.getFileDetailsClass().getThread());

                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        });
    }



}
