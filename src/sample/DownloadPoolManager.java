package sample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DownloadPoolManager
{
    private static DownloadPoolManager instance = null;
    private ExecutorService executorService;

    private DownloadPoolManager()
    {
        executorService = Executors.newFixedThreadPool(5);
    }

    public static DownloadPoolManager getDownloadPoolManager()
    {
        if(instance == null) instance = new DownloadPoolManager();
        return instance;
    }

    public void addDownloadToPool()
    {

    }
}
