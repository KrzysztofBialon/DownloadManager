package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sample.FileDetailsBuilder;
import sample.FileDetailsDirector;

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
                                                System.out.println("step1");
                                                String extension =  extensionSelectionBox.getValue().toString();
                                                System.out.println("step2");
                                                FileDetailsBuilder fileDetailsBuilder = new FileDetailsBuilder(url, extension);
                                                System.out.println("step3");
                                                FileDetailsDirector fileDetailsDirector = new FileDetailsDirector(fileDetailsBuilder);
                                                System.out.println("step4");
                                                fileDetailsDirector.constructFileDetails();
                                                System.out.println("step5");
                                                downloadListWrapper.getChildren().add(fileDetailsDirector.getFileDetailsClass().getBar().getWrapper());
                                                System.out.println("step6");
                                                downloadPool.execute(fileDetailsDirector.getFileDetailsClass().getThread());
                                                System.out.println("step7");
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        });
    }



}
