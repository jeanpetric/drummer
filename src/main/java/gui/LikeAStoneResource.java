package gui;

import engine.Drum;
import engine.HitNotation;
import engine.Note;
import engine.Track;

/**
 * Created by jean on 29/01/17.
 */
public class LikeAStoneResource {

    public static Track getTrack() {
        Track track = new Track();

        Note emptyNote = new Note();
        Note crashBass = new Note();
        crashBass.put(Drum.EDrum.CRASH, new HitNotation(Drum.EDrum.CRASH, Drum.EType.CYMBAL_HARD));
        crashBass.put(Drum.EDrum.BASS_DRUM, new HitNotation(Drum.EDrum.BASS_DRUM, Drum.EType.DRUM_SOFT));
        Note hat = new Note();
        hat.put(Drum.EDrum.HAT, new HitNotation(Drum.EDrum.HAT, Drum.EType.CYMBAL_SOFT));
        Note hatSnare = new Note();
        hatSnare.put(Drum.EDrum.HAT, new HitNotation(Drum.EDrum.HAT, Drum.EType.CYMBAL_SOFT));
        hatSnare.put(Drum.EDrum.SNARE, new HitNotation(Drum.EDrum.SNARE, Drum.EType.DRUM_SOFT));
        Note hatBass = new Note();
        hatBass.put(Drum.EDrum.HAT, new HitNotation(Drum.EDrum.HAT, Drum.EType.CYMBAL_SOFT));
        hatBass.put(Drum.EDrum.BASS_DRUM, new HitNotation(Drum.EDrum.BASS_DRUM, Drum.EType.DRUM_SOFT));
        Note snareSoft = new Note();
        snareSoft.put(Drum.EDrum.SNARE, new HitNotation(Drum.EDrum.SNARE, Drum.EType.DRUM_SOFT));

        int bit = 1;
        track.put(bit++, crashBass); // 1
        track.put(bit++, emptyNote); // e
        track.put(bit++, hat); // &
        track.put(bit++, emptyNote); // a
        track.put(bit++, hatSnare); // 2
        track.put(bit++, emptyNote); // e
        track.put(bit++, hat); // &
        track.put(bit++, snareSoft); // a
        track.put(bit++, hatBass); // 3
        track.put(bit++, snareSoft); // e
        track.put(bit++, hatBass); // &
        track.put(bit++, emptyNote); // a
        track.put(bit++, hatSnare); // 4
        track.put(bit++, emptyNote); // e
        track.put(bit++, hat); // &
        track.put(bit++, emptyNote); // a

        return track;
    }
}
