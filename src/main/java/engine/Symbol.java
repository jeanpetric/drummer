package engine;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jean on 07/03/17.
 */
public class Symbol {
    // enum mapping symbol with a hit type
    public static final Map<Character, Drum.EType> type;
    static {
        Map<Character, Drum.EType> map = new HashMap<>();
        map.put('x', Drum.EType.CYMBAL_SOFT);
        map.put('X', Drum.EType.CYMBAL_HARD);
        map.put('o', Drum.EType.DRUM_SOFT);
        map.put('O', Drum.EType.DRUM_HARD);
        map.put('#', Drum.EType.CHOKE);
        map.put('s', Drum.EType.CYMBAL_SPLASH);
        map.put('c', Drum.EType.CYMBAL_CHINA);
        map.put('g', Drum.EType.GHOST);
        map.put('d', Drum.EType.DRAG);
        map.put('@', Drum.EType.SNARE_RIM);
        type = Collections.unmodifiableMap(map);
    }
}
