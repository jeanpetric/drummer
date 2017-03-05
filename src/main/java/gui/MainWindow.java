package gui;

import engine.Track;
import indicator.BasicDrumTab;
import indicator.DrumTab;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


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
}
