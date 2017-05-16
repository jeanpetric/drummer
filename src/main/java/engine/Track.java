package engine;

import java.util.HashMap;

/**
 * Created by jean on 29/01/17.
 */
public class Track extends HashMap<Number, Note> {

    public void copyBar(int startPosition, int endPosition, int newStartPosition) {
        System.out.println("inserted bug");
        for (int position = startPosition; position <= endPosition; position++) {
            put(newStartPosition++, get(position));
        }
    }
}
