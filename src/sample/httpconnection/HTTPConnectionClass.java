package sample.httpconnection;

import sample.gui.elements.alert.AlertFactory;
import sample.gui.elements.alert.CouldntConnectToServerAlert;
import sample.logic.interfaces.IHTTPConnection;
import sample.logic.util.fileClass.FileDetailsClass;
import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;

public class HTTPConnectionClass implements IHTTPConnection {
    
    @Override
    public void setConnection(FileDetailsClass detailsClass) throws IOException
    {
       ConnectToServer.connect(detailsClass, false);
    }
}
