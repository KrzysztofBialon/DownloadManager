package sample;

import sample.download.SaveFileFromURL;
import sample.httpconnection.HTTPConnectionClass;

import java.net.URL;

public class ConnectionBuilder {
    public static void createSaveFileClass(String url, String extension) throws Exception {
        SaveFileFromURL.runDownload(HTTPConnectionClass.setConnection(url, extension));
    }
}
