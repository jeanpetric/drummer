package engine;

/**
 * Created by jean on 29/01/17.
 */
public class HitNotation extends Hit {
    public HitNotation(Drum.EDrum drum, Drum.EType type) {
        super(drum, type);
    }

    public String symbol() {
        String result = "-";

        // CRASH OR RIDE
        if (drum == Drum.EDrum.CRASH || drum == Drum.EDrum.RIDE) {
            if (type == Drum.EType.CYMBAL_HARD) {
                result = CYMBAL_HARD;
            } else {
                result = CYMBAL_SOFT;
            }
        }

        // HI-HAT
        else if (drum == Drum.EDrum.HAT) {
            if (type == Drum.EType.CYMBAL_HARD) {
                result = CYMBAL_HARD;
            } else if (type == Drum.EType.CYMBAL_SOFT) {
                result = CYMBAL_SOFT;
            } else if (type == Drum.EType.HAT_OPEN) {
                result = HAT_OPEN;
            }
        }

        // SNARE
        else if (drum == Drum.EDrum.SNARE) {
            if (type == Drum.EType.DRUM_HARD) {
                result = DRUM_HARD;
            } else if (type == Drum.EType.DRUM_SOFT) {
                result = DRUM_SOFT;
            }
        }

        // BASS
        else if (drum == Drum.EDrum.BASS_DRUM) {
            result = DRUM_SOFT;
        }

        return result;
    }
}
