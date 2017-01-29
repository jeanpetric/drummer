package indicator;

import engine.Drum;
import engine.Track;

/**
 * Created by jean on 29/01/17.
 */
public class BasicDrumTab extends DrumTab {

    public BasicDrumTab(Track track) {
        super(track);
    }

    public void drawTabPage(int start, int end, int length) {
        startPosition = start;
        endPosition = end;
        pageLength = length;
        drawTab();
    }

    public void drawNextTabPage() {
        startPosition = startPosition + pageLength;
        endPosition = endPosition + pageLength;
        drawTabPage(startPosition, endPosition, pageLength);
    }

    private void drawTab() {
        drawTabLine(Drum.EDrum.CRASH);
        drawTabLine(Drum.EDrum.RIDE);
        drawTabLine(Drum.EDrum.HAT);
        drawTabLine(Drum.EDrum.SNARE);
        drawTabLine(Drum.EDrum.HIGH_TOM);
        drawTabLine(Drum.EDrum.LOW_TOM);
        drawTabLine(Drum.EDrum.FLOOR_TOM);
        drawTabLine(Drum.EDrum.BASS_DRUM);
    }
}
