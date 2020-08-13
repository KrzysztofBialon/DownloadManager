package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.httpconnection.HTTPConnectionClass;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

            Parent root = FXMLLoader.load(getClass().getResource("gui/sample.fxml"));
            primaryStage.setTitle("Hello World");
            primaryStage.setScene(new Scene(root, 300, 600));
            primaryStage.show();
    }


    public static void main(String[] args) throws Exception {
        /*String fileUrl = "https://javadl.oracle.com/webapps/download/AutoDL?BundleId=242990_a4634525489241b9a9e1aa73d9e118e6";

        HTTPConnectionClass httpConnectionClass = new HTTPConnectionClass(fileUrl);

        httpConnectionClass.setConnection();*/

        launch(args);
    }
}
