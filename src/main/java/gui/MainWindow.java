package gui;

import engine.Track;
import indicator.BasicDrumTab;
import indicator.DrumTab;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import tab.TabLoader;
import tab.TabVisitor;
import utils.LikeAStoneResource;

import java.io.File;
import java.io.IOException;


/**
 * Created by jean on 30/01/17.
 */
public class MainWindow extends Window {
    @FXML
    TextArea tabArea;
    @FXML
    Rectangle tabCursor;
    @FXML
    TextField tempo;

    private AbstractModePlayer player = null;
    private Track track = null; // delete this after implementing load tab

    public void load(ActionEvent actionEvent) throws IOException {
        FileChooser tabFile = new FileChooser();
        tabFile.setTitle("Open a tab");
        File selectedFile = tabFile.showOpenDialog(this);
        TabLoader tabLoader = new TabLoader();
        tabLoader.load(selectedFile.getCanonicalPath().toString());
        TabVisitor tabTrack = new TabVisitor(tabLoader);
        track = tabTrack.getTrack();
        DrumTab tab = new BasicDrumTab(track);
        tabArea.setText(tab.drawTabPage(1, track.size(), track.size()).getCurrentTab());
        setPlayer();
    }

    public void play(ActionEvent actionEvent) throws Exception {
        setPlayer();
        player.play();
    }

    public void pause(ActionEvent actionEvent) {
        player.pause();
    }

    public void stop(ActionEvent actionEvent) {
        player.stop();
    }

    public void reset(ActionEvent actionEvent) {
        player.reset();
    }

    public void adjustSize(Stage stage) {
        tabArea.prefWidthProperty().bind(stage.widthProperty());
    }

    public void backward(ActionEvent actionEvent) {
        player.backward();
    }

    public void forward(ActionEvent actionEvent) {
        player.forward();
    }

    public void openConfiguration(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/ConfigurationWindow.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Configuration");
            stage.setScene(new Scene(root1));
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //TODO: this should really be handled by some kind of factory...
    private void setPlayer() {
        String playerMode = DrummerProperties.getProperty("playerMode");
        if (playerMode.equals("running")) {
            player = new RunningModePlayer(tabArea, tabCursor, tempo, track);
        } else {
            player = new StaticModePlayer(tabArea, tabCursor, tempo, track);
        }
    }
}
