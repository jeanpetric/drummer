package gui;

import engine.Track;
import indicator.BasicDrumTab;
import indicator.DrumTab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;

/**
 * Created by jean on 05/03/17.
 */
public class StaticModePlayer extends AbstractModePlayer {
    public StaticModePlayer(TextArea tab, Rectangle cursor, TextField tempo, Track track) {
        super(tab, cursor, tempo, track);
    }

    @Override
    public void updateTabArea() {
        DrumTab tab = new BasicDrumTab(track);
        tabArea.setText(tab.drawTabPage(cycle+1, track.size(), track.size()).getCurrentTab());
        if (cycle >= track.size()) {
            cycle = 0;
        }
    }

    @Override
    public void updateTabCursor() {
    }
}
