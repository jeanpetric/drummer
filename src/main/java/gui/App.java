package gui;

/**
 * Created by jean on 30/01/17.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/MainWindow.fxml"));
        Parent root = fxmlLoader.load();

        MainWindow controller = fxmlLoader.<MainWindow>getController();
        controller.adjustSize(primaryStage);

        primaryStage.setTitle("Drummer");
        primaryStage.setScene(new Scene(root, 1200, 400));
        primaryStage.show();
    }
}
