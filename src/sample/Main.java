package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
            Parent root = FXMLLoader.load(getClass().getResource("gui/fxml/sample.fxml"));
            primaryStage.setTitle("Download Manager");
            primaryStage.setScene(new Scene(root, 300, 600));
            primaryStage.show();
    }


    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
