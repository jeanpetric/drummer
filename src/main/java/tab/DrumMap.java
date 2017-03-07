package tab;

import engine.Drum;

import java.util.HashMap;

/**
 * Created by jean on 05/02/17.
 */
public class DrumMap extends HashMap<String, Drum.EDrum> {
    public DrumMap() {
        put("C", Drum.EDrum.CRASH);
        put("CC", Drum.EDrum.CRASH);
        put("HH", Drum.EDrum.HAT);
        put("H", Drum.EDrum.HAT);
        put("R", Drum.EDrum.RIDE);
        put("RC", Drum.EDrum.RIDE);
        put("S", Drum.EDrum.SNARE);
        put("SD", Drum.EDrum.SNARE);
        put("T1", Drum.EDrum.HIGH_TOM);
        put("HT", Drum.EDrum.HIGH_TOM);
        put("T", Drum.EDrum.HIGH_TOM);
        put("T2", Drum.EDrum.LOW_TOM);
        put("LT", Drum.EDrum.LOW_TOM);
        put("t", Drum.EDrum.LOW_TOM);
        put("FT", Drum.EDrum.FLOOR_TOM);
        put("B", Drum.EDrum.BASS_DRUM);
        put("BD", Drum.EDrum.BASS_DRUM);
        put("P", Drum.EDrum.HAT_PEDAL);
    }
}
