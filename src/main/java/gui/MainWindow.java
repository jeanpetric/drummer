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
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


/**
 * Created by jean on 30/01/17.
 */
public class MainWindow {
    @FXML
    TextArea tabArea;
    @FXML
    Rectangle tabCursor;
    @FXML
    TextField tempo;

    private AbstractModePlayer player = null;

    Line line = new Line();

    public void load(ActionEvent actionEvent) {
        Track track = LikeAStoneResource.getTrack();
        DrumTab tab = new BasicDrumTab(track);
        track.copyBar(1, 16, 1*16+1);
        track.copyBar(1, 16, 2*16+1);
        track.copyBar(1, 16, 3*16+1);
        tabArea.setText(tab.drawTabPage(1, track.size(), track.size()).getCurrentTab());
        player = new RunningModePlayer(tabArea, tabCursor, tempo);
    }

    public void play(ActionEvent actionEvent) throws Exception {
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
}
