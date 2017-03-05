package gui;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;

/**
 * Created by jean on 05/03/17.
 */
public class RunningModePlayer extends AbstractModePlayer {
    public RunningModePlayer(TextArea tab, Rectangle cursor, TextField tempo) {
        super(tab, cursor, tempo);
    }

    @Override
    public void updateTabArea() {
    }

    @Override
    public void updateTabCursor() {
        tabCursor.setX(CURSOR_X_OFFSET*cycle);
    }
}
