package sample.gui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class DownloadItemBar {

    private Label filename;
    private Label downloadStatus;
    private Button startBtn;
    private Button pauseBtn;
    private Button cancelBtn;
    private ProgressBar progressBar;

    public DownloadItemBar(Label filename, double fileSize) {
        this.filename = filename;
        this.progressBar = new ProgressBar(fileSize);

        startBtn = new Button("S");
        pauseBtn = new Button("P");
        pauseBtn = new Button("C");
    }
}
