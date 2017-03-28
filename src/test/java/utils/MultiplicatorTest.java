package utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jean on 28/03/17.
 */
public class MultiplicatorTest {

    @Test
    public void multiplicator() throws Exception {
        Multiplicator m = new Multiplicator();
        int a = m.multiplicator(10);
        assertEquals(20, a);
    }

}