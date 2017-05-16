package engine;

/**
 * Created by jean on 29/01/17.
 */
public abstract class Hit {
    protected final String CYMBAL_SOFT = "x";
    protected final String CYMBAL_HARD = "X";
    protected final String HAT_OPEN = "o";
    protected final String DRUM_SOFT = "o";
    protected final String DRUM_HARD = "O";
    protected final String CHOKE = "#";
    protected final String CYMBAL_SPLASH = "s";
    protected final String CYMBAL_CHINA = "c";
    protected final String BELL = "b";
    protected final String GHOST = "g";
    protected final String FLAM = "f";
    protected final String DRAG = "d";
    protected final String ROLL_ACCENTED = "B";
    protected final String SNARE_RIM = "@";

    Drum.EDrum drum;
    Drum.EType type;

    public Hit(Drum.EDrum drum, Drum.EType type) {
        this.drum = drum;
        this.type = type;
    }

    public abstract String symbol();
}
