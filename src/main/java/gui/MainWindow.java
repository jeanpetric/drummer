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

    private static final int MAX_CYCLE = 16*4;
    private static final double CURSOR_X_OFFSET = 16.83;
    private Timeline timer;
    private int cycle;
    private boolean pause = false;

    Line line = new Line();

    public void load(ActionEvent actionEvent) {
        Track track = LikeAStoneResource.getTrack();
        DrumTab tab = new BasicDrumTab(track);
        track.copyBar(1, 16, 1*16+1);
        track.copyBar(1, 16, 2*16+1);
        track.copyBar(1, 16, 3*16+1);
        tabArea.setText(tab.drawTabPage(1, track.size(), track.size()).getCurrentTab());
    }

    public void play(ActionEvent actionEvent) throws Exception {
        createTimer(calculateTempo(tempo.getText()));
    }

    private double calculateTempo(String text) {
        // only valid for quater notes, right? (1/4)
        return 60. / Integer.valueOf(text) * 0.25 * 1000;
    }

    public void pause(ActionEvent actionEvent) {
        pause = pause == false ? true : false;
    }

    public void stop(ActionEvent actionEvent) {
        resetTimer();
    }

    public void reset(ActionEvent actionEvent) {
        resetTimer();
        updateCursor();
    }

    public void adjustSize(Stage stage) {
        tabArea.prefWidthProperty().bind(stage.widthProperty());
    }

    public void backward(ActionEvent actionEvent) {
        tabCursor.setX(tabCursor.getX() - tabCursor.getWidth());
    }

    public void forward(ActionEvent actionEvent) {
        updateCycle();
        updateCursor();
    }

    public void updateTempo(KeyEvent keyEvent) {
//        createTimer(tempo.getText());
    }

    private void createTimer(double duration) {
        System.out.println(duration);
        resetTimer();
        timer = new Timeline(new KeyFrame(Duration.millis(duration), event -> {
            updateCycle();
            updateCursor();
        }));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }

    private void updateCycle() {
        if (pause == true) {
            return;
        }
        cycle++;
        if (cycle >= MAX_CYCLE) {
            cycle = 0;
        }
    }

    private void updateCursor() {
        tabCursor.setX(CURSOR_X_OFFSET*cycle);
    }

    private void resetTimer() {
        pause = false;
        cycle = -1;
        if (timer != null) {
            timer.stop();
        }
        timer = null;
    }

}
