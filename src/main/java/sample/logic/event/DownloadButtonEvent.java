package sample.logic.event;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import sample.logic.thread.DownloadActionLogicThread;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;

public class DownloadButtonEvent implements EventHandler {

    private TextField urlInputField;
    private ComboBox extensionSelectionBox;
    private VBox downloadListWrapper;
    private ExecutorService downloadUserActionThreadPool;
    private URL url = null;

    public DownloadButtonEvent(TextField urlInputField, ComboBox extensionSelectionBox, VBox downloadListWrapper, ExecutorService downloadUserActionThreadPool) {
        this.urlInputField = urlInputField;
        this.extensionSelectionBox = extensionSelectionBox;
        this.downloadListWrapper = downloadListWrapper;
        this.downloadUserActionThreadPool = downloadUserActionThreadPool;
    }

    @Override
    public void handle(Event event) {
        {
            //Create URL if malformed inform user and quit method
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

        }
    }
}
