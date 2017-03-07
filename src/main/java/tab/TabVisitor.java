package tab;

import engine.*;

/**
 * Created by jean on 05/02/17.
 */
public class TabVisitor {
    private Track track;
    private int lastBeat = 1;
    private int crashBeat = 1;
    private int rideBeat = 1;
    private int hihatBeat = 1;
    private int snareBeat = 1;
    private int tom1Beat = 1;
    private int tom2Beat = 1;
    private int floorTomBeat = 1;
    private int bassBeat = 1;
    private int pedalBeat = 1;

    public TabVisitor(TabLoader tabLoader) {
        track = new Track();
        String line;

        while ((line = tabLoader.nextLine()) != null) {
            if (line.equals("\n") || line.equals("")) {
                crashBeat = lastBeat;
                rideBeat = lastBeat;
                hihatBeat = lastBeat;
                snareBeat = lastBeat;
                tom1Beat = lastBeat;
                tom2Beat = lastBeat;
                floorTomBeat = lastBeat;
                bassBeat = lastBeat;
                pedalBeat = lastBeat;
                continue;
            }
            if (line.startsWith("Cr")) visit(line, crashBeat, Drum.EDrum.CRASH);
            else if (line.startsWith("Ri")) visit(line, rideBeat, Drum.EDrum.RIDE);
            else if (line.startsWith("Hh")) visit(line, hihatBeat, Drum.EDrum.HAT);
            else if (line.startsWith("Sn")) visit(line, snareBeat, Drum.EDrum.SNARE);
            else if (line.startsWith("T1")) visit(line, tom1Beat, Drum.EDrum.HIGH_TOM);
            else if (line.startsWith("T2")) visit(line, tom2Beat, Drum.EDrum.LOW_TOM);
            else if (line.startsWith("Ft")) visit(line, floorTomBeat, Drum.EDrum.FLOOR_TOM);
            else if (line.startsWith("B")) visit(line, bassBeat, Drum.EDrum.BASS_DRUM);
            else if (line.startsWith("P")) visit(line, pedalBeat, Drum.EDrum.HAT_PEDAL);
            else visitAnnotation(line);
        }
    }

    public void visit(String line, int beat, Drum.EDrum drum) {
        for (int i = 0; i < line.length(); i++) {
            char currentChar = line.charAt(i);
            if (currentChar == '|') {
                continue;
            }
            Note currentNote = track.get(beat);
            if (currentNote == null) {
                currentNote = new Note();
                track.put(beat, currentNote);
            }
            if (Symbol.type.get(currentChar) != null) {
                currentNote.put(drum, new HitNotation(drum, Symbol.type.get(currentChar)));
                beat++;
            } else if (currentChar == '-') {
                beat++;
            }
        }
        lastBeat = beat;
    }

    public void visitAnnotation(String line) {
        //handle bar's repetitions
    }

    public Track getTrack() {
        return track;
    }
}
