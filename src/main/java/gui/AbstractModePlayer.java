package gui;

import engine.Track;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * Created by jean on 05/03/17.
 */
public abstract class AbstractModePlayer {
    protected TextArea tabArea;
    protected Rectangle tabCursor;
    protected TextField tempo;
    protected Track track;

    protected static final int MAX_CYCLE = 16*4;
    protected static final double CURSOR_X_OFFSET = 16.83;
    protected Timeline timer;
    protected int cycle;
    protected boolean pause = false;

    public AbstractModePlayer(TextArea tab, Rectangle cursor, TextField tempo, Track track) {
        this.tabArea = tab;
        this.tabCursor = cursor;
        this.tempo = tempo;
        this.track = track;
    }

    public void play() {
        createTimer(calculateTempo(tempo.getText()));
    }

    public void pause() {
        pause = pause == false ? true : false;
    }

    public void stop() {
        resetTimer();
    }

    public void reset() {
        resetTimer();
        updateTabCursor();
    }

    public void backward() {
        tabCursor.setX(tabCursor.getX() - tabCursor.getWidth());
    }

    public void forward() {
        updateCycle();
        updateTabCursor();
    }

    private double calculateTempo(String text) {
        // only valid for quater notes, right? (1/4)
        return 60. / Integer.valueOf(text) * 0.25 * 1000;
    }

    private void createTimer(double duration) {
        resetTimer();
        timer = new Timeline(new KeyFrame(Duration.millis(duration), event -> {
            updateCycle();
            updateTabArea();
            updateTabCursor();
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

    private void resetTimer() {
        pause = false;
        cycle = -1;
        if (timer != null) {
            timer.stop();
        }
        timer = null;
    }

    public abstract void updateTabArea();
    public abstract void updateTabCursor();
}
