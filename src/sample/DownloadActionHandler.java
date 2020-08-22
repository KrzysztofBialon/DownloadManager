package sample;

import sample.download.SaveFileFromURL;
import sample.download.file.DownloadFileTask;
import sample.gui.DownloadItemBar;
import sample.httpconnection.HTTPConnectionClass;

import java.net.MalformedURLException;
import java.net.URL;

public class DownloadActionHandler
{
    private SaveFileFromURL save;
    private DownloadFileTask task;
    private DownloadItemBar bar;

    public static void downloadOnClick(String url, String fileExt)
    {
        try
        {
            HTTPConnectionClass connection = new HTTPConnectionClass(url);
            if(connection.setConnection() == 200)
            {
                SaveFileFromURL save = new SaveFileFromURL(new URL(url), fileExt);
                DownloadItemBar bar = new DownloadItemBar()
                save.runDownload();
            } else System.out.println(connection.setConnection());;

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
