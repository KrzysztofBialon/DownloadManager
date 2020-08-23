package sample;

import sample.download.file.DownloadFileTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DownloadPoolManager
{
    private static ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static void addDownloadToPool(DownloadFileTask task)
    {
        executorService.execute(task);
    }
}
