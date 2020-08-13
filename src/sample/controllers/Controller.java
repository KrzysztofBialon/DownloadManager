package sample.controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

public class Controller {

    @FXML
    private ListView downloadsList;

    private ObservableList<DownloadItem> downloadsItemsObservableList;
}
