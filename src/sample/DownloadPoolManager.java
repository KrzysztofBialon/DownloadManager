package sample;

import sample.download.file.DownloadFileTask;
import sample.gui.elements.DownloadItemBar;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DownloadPoolManager
{
    private static ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static void addDownloadToPool(DownloadFileTask task, DownloadItemBar bar)
    {
        bar.getProgressBar().progressProperty().bind(task.progressProperty());
        executorService.execute(task);
    }
}
