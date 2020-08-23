package sample.gui.elements;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class DownloadItemBar {

    private HBox wrapper;
    private Label downloadStatus = new Label("Awaiting");
    private final Label filename;
    private final Button startBtn;
    private final Button pauseBtn;
    private final Button cancelBtn;
    private ProgressBar progressBar;

    public DownloadItemBar(String filename, double fileSize) {

        this.wrapper = new HBox(6);

        this.filename = new Label(filename);
        this.filename.setMinSize(60, 20);
        this.filename.setMaxSize(100, 20);
        this.filename.prefWidthProperty().bind(wrapper.widthProperty());
        this.filename.prefHeightProperty().bind(wrapper.heightProperty());

        this.progressBar = new ProgressBar(fileSize);
        this.progressBar.setMinSize(60, 10);
        this.progressBar.setMaxSize(100, 20);
        this.progressBar.prefWidthProperty().bind(wrapper.widthProperty());
        this.progressBar.prefHeightProperty().bind(wrapper.heightProperty());

        this.startBtn = new Button("S");
        this.startBtn.setMinSize(60, 20);
        this.startBtn.setMaxSize(100, 20);
        this.startBtn.prefWidthProperty().bind(wrapper.widthProperty());
        this.startBtn.prefHeightProperty().bind(wrapper.heightProperty());

        this.pauseBtn = new Button("P");
        this.pauseBtn.setMinSize(60, 20);
        this.pauseBtn.setMaxSize(100, 20);
        this.pauseBtn.prefWidthProperty().bind(wrapper.widthProperty());
        this.pauseBtn.prefHeightProperty().bind(wrapper.heightProperty());

        this.cancelBtn = new Button("C");
        this.cancelBtn.setMinSize(60, 20);
        this.cancelBtn.setMaxSize(100, 20);
        this.cancelBtn.prefWidthProperty().bind(wrapper.widthProperty());
        this.cancelBtn.prefHeightProperty().bind(wrapper.heightProperty());

        wrapper.getChildren().setAll(
                this.filename, progressBar, downloadStatus, startBtn, pauseBtn, cancelBtn);
    }

    public HBox getWrapper() {
        return wrapper;
    }

    public ProgressBar getProgressBar(){return progressBar;}
}
