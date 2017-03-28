package engine;

import indicator.BasicDrumTab;
import indicator.DrumTab;
import org.junit.Test;
import share.LikeAStoneResource;

import static org.junit.Assert.*;

/**
 * Created by jean on 29/01/17.
 */
public class TrackTest {
    @Test
    public void copyBar() throws Exception {
        Track testTrack = LikeAStoneResource.getTrack();
        testTrack.copyBar(1, 16, 16*1+1);
        testTrack.copyBar(1, 16, 16*2+1);
        testTrack.copyBar(1, 16, 16*3+1);

        assertEquals(16*4, testTrack.size());
    }

}