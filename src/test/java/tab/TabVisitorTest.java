package tab;

import engine.Track;
import indicator.BasicDrumTab;
import indicator.DrumTab;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jean on 07/03/17.
 */
public class TabVisitorTest {
    private TabLoader tabLoader;
    private Track track;

    @Before
    public void setUp() {
        tabLoader = new TabLoader();
        tabLoader.add("Cr|x---------------|----------------|----------------|----------------|");
        tabLoader.add("T1|o---o---o---o---|o---o---o---o---|o---o---o---o---|o---o---o---o---|");
        tabLoader.add("B |o-----o-o-------|o-----o-o-------|o-----o-o-------|o-----o-o-------|");
        tabLoader.add("P |x---x---x---x---|x---x---x---x---|x---x---x---x---|x---x---x---x---|");
        tabLoader.add("\n");
        tabLoader.add("Cr|x---------------|----------------|----------------|----------------|");
        tabLoader.add("T1|o---o---o---o---|o---o---o---o---|o---o---o---o---|o---o---o---o---|");
        tabLoader.add("B |o-----o-o-------|o-----o-o-------|o-----o-o-------|o-----o-o-------|");
        tabLoader.add("P |x---x---x---x---|x---x---x---x---|x---x---x---x---|x---x---x---x---|");
        tabLoader.add("\n");
        tabLoader.add(null);

        TabVisitor tabVisitor = new TabVisitor(tabLoader);
        track = tabVisitor.getTrack();
    }

    @After
    public void tearDown() {
        tabLoader = null;
    }

    @Test
    public void checkFirstNoteInFirstBar() {
        int expectedResult = 4;
        int actualResult = track.get(1).size();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void checkFirstNoteInSecondBar() {
        int expectedResult = 3;
        int actualResult = track.get(16+1).size();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void checkFirstNoteInLastBar() {
        int expectedResult = 3;
        int actualResult = track.get(128-16+1).size();
        assertEquals(expectedResult, actualResult);
    }
}