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

    public DrumTab(Track track) {
        this.track = track;
    }

    public abstract void drawTabPage(int start, int end, int pageLength);
    public abstract void drawNextTabPage();

    public void drawTabLine(Drum.EDrum drum) {
        for (int position = startPosition; position <= endPosition; position++) {
            if (track.get(position).get(drum) == null) {
                System.out.print("- ");
            } else {
                System.out.print(track.get(position).get(drum).symbol() + " ");
            }
        }
        System.out.print("\n");
    }
}
