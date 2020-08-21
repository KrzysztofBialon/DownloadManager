package sample.gui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;

public class DownloadItemBar {

    private HBox wrapper = new HBox();
    private Label filename;
    private Label downloadStatus = new Label("Awaiting");
    private final Button startBtn;
    private final Button pauseBtn;
    private final Button cancelBtn;
    private ProgressBar progressBar;

    public DownloadItemBar(String filename, double fileSize) {
        this.filename = new Label(filename);
        this.progressBar = new ProgressBar(fileSize);
        progressBar.setPrefWidth(1000000);
        startBtn = new Button("S");
        pauseBtn = new Button("P");
        cancelBtn = new Button("C");
        wrapper.getChildren().setAll(this.filename, progressBar, downloadStatus, startBtn, pauseBtn, cancelBtn);
    }

    public HBox getWrapper() {
        return wrapper;
    }
}
