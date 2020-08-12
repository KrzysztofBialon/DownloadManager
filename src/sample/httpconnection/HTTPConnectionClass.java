package sample.httpconnection;

import sample.download.SaveFileFromURL;

import javax.net.ssl.HttpsURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HTTPConnectionClass {

    private URL url;
    private String fileURL;

    public HTTPConnectionClass(String url, String fileURL) throws MalformedURLException {
        this.url = new URL(url);
        this.fileURL = fileURL;
    }

    public void setConnection() throws Exception
    {
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
        httpsURLConnection.setRequestMethod("GET");
        httpsURLConnection.connect();

        SaveFileFromURL.saveFile(fileURL ,url);
    }
}
