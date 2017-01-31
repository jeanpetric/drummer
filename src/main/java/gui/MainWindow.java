package gui;

import engine.Track;
import indicator.BasicDrumTab;
import indicator.DrumTab;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
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

    Line line = new Line();

    public void load(ActionEvent actionEvent) {
        Track track = LikeAStoneResource.getTrack();
        DrumTab tab = new BasicDrumTab(track);
        track.copyBar(1, 16, 1*16+1);
        track.copyBar(1, 16, 2*16+1);
        track.copyBar(1, 16, 3*16+1);
        tabArea.setText(tab.drawTabPage(1, track.size(), track.size()).getCurrentTab());
    }

    public void play(ActionEvent actionEvent) {
    }

    public void pause(ActionEvent actionEvent) {
    }

    public void stop(ActionEvent actionEvent) {
    }

    public void adjustSize(Stage stage) {
        tabArea.prefWidthProperty().bind(stage.widthProperty());
    }

    public void backward(ActionEvent actionEvent) {
        tabCursor.setX(tabCursor.getX() - tabCursor.getWidth());
    }

    public void forward(ActionEvent actionEvent) {
        tabCursor.setX(tabCursor.getX() + tabCursor.getWidth());
    }
}
