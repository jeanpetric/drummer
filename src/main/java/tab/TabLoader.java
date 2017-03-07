package tab;

import java.util.ArrayList;

/**
 * Created by jean on 05/03/17.
 */
public class TabLoader extends ArrayList<String> {
    int index = 0;

    public String nextLine() {
        return get(index++);
    }
}
