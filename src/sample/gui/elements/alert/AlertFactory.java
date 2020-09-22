package sample.gui.elements.alert;

import javafx.scene.control.Alert;

import java.util.HashMap;
import java.util.Map;

public class AlertFactory
{
    private static final Map<String, Alert> alertFactoryMap = new HashMap<String, Alert>()
    {
        {
            put("CantCreateFileAlert", new CantCreateFileAlert());
            put("CouldntConnectToServerAlert", new CouldntConnectToServerAlert());
            put("FileNotFoundAlert", new FileNotFoundAlert());
            put("NoResourceIOAlert", new NoResourceIOAlert());
            put("ProtocolAlert", new ProtocolAlert());
        }
    };


    public static Alert createAlert(String alertType)
    {
        return alertFactoryMap.get(alertType);
    }
}
