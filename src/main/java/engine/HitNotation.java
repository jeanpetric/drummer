package engine;

/**
 * Created by jean on 29/01/17.
 */
public class HitNotation extends HitDummyRename {
    public  HitNotation(Drum.EDrum drum, Drum.EType type) {
        super(drum, type);
    }

    public String symbol() {
        String result = "-";

        // CRASH OR RIDE
        if (drum == Drum.EDrum.CRASH || drum == Drum.EDrum.RIDE) {
            if (type == Drum.EType.CYMBAL_HARD) {
                result = CYMBAL_HARD;
            } else if (type == Drum.EType.CYMBAL_SOFT) {
                result = CYMBAL_SOFT;
            } else if (type == Drum.EType.CHOKE) {
                result = CHOKE;
            } else if (type == Drum.EType.CYMBAL_SPLASH) {
                result = CYMBAL_SPLASH;
            } else if (type == Drum.EType.GHOST) {
                result = GHOST;
            } else if (type == Drum.EType.CYMBAL_CHINA) {
                result = CYMBAL_CHINA;
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
            } else if (type == Drum.EType.GHOST) {
                result = GHOST;
            }
        }

        // SNARE and TOMs
        else if (drum == Drum.EDrum.SNARE || drum == Drum.EDrum.HIGH_TOM
                || drum == Drum.EDrum.LOW_TOM || drum == Drum.EDrum.FLOOR_TOM) {
            if (type == Drum.EType.DRUM_HARD) {
                result = DRUM_HARD;
            } else if (type == Drum.EType.DRUM_SOFT) {
                result = DRUM_SOFT;
            } else if (type == Drum.EType.GHOST) {
                result = GHOST;
            } else if (type == Drum.EType.SNARE_RIM) {
                result = SNARE_RIM;
            } else if (type == Drum.EType.DRAG) {
                result = DRAG;
            }
        }

        // BASS
        else if (drum == Drum.EDrum.BASS_DRUM) {
            result = DRUM_SOFT;
        }

        // HI HAT PEDAL
        else if (drum == Drum.EDrum.HAT_PEDAL) {
            result = CYMBAL_HARD;
        }

        return result;
    }
}
