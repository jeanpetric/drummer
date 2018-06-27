/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

/**
 *
 * @author Jean Petric
 */
public class SingleNote {
    private final Drum.EDrum drum;
    private final Drum.EType type;
    
    public SingleNote(Drum.EDrum drum, Drum.EType type) {
        this.drum = drum;
        this.type = type;
    }

    public Drum.EDrum getDrum() {
        return drum;
    }

    public Drum.EType getType() {
        return type;
    }
}
