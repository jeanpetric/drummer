package indicator;

import engine.Track;
import share.LikeAStoneResource;

import static org.junit.Assert.*;

/**
 * Created by jean on 29/01/17.
 */
public class BasicDrumTabTest {
    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.Test
    public void drawTabPage() throws Exception {
        Track track = LikeAStoneResource.getTrack();
        DrumTab drumTab = new BasicDrumTab(track);
        drumTab.drawTabPage(1, track.size(), track.size());
        String tab = drumTab.getCurrentTab();
        String[] lines = tab.split("\r\n|\r|\n");
        assertEquals(9, lines.length);
    }

    @org.junit.Test
    public void drawNextTabPage() throws Exception {
    }

}