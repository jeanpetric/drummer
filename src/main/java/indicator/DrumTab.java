package indicator;

import engine.Drum;
import engine.Track;

/**
 * Created by jean on 29/01/17.
 */
public abstract class DrumTab {
    protected final Track track;
    protected int startPosition;
    protected int endPosition;
    protected int pageLength;
    protected String currentTab;

    public DrumTab(Track track) {
        currentTab = "";
        this.track = track;
    }

    public abstract DrumTab drawTabPage(int start, int end, int pageLength);
    public abstract DrumTab drawNextTabPage();

    public String getCurrentTab() {
        return currentTab;
    }

    public void drawTabLine(Drum.EDrum drum) {
        for (int position = startPosition; position <= endPosition; position++) {
            if (track.get(position).get(drum) == null) {
                currentTab += "- ";
            } else {
                currentTab += track.get(position).get(drum).symbol() + " ";
            }
        }
        currentTab += "\n";
    }
}
