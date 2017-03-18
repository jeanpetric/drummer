package gui;

import engine.Track;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;

/**
 * Created by jean on 05/03/17.
 */
public class RunningModePlayer extends AbstractModePlayer {
    private static final int MAX_CYCLE = 16*4;
    private static final double CURSOR_X_OFFSET = 30.1;

    public RunningModePlayer(TextArea tab, Rectangle cursor, TextField tempo, Track track) {
        super(tab, cursor, tempo, track);
    }

    @Override
    public void updateTabArea() {
    }

    @Override
    public void updateTabCursor() {
        if (cycle >= MAX_CYCLE) {
            cycle = 0;
        }
        tabCursor.setX(CURSOR_X_OFFSET*cycle);
    }
}
