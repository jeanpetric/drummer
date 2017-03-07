package tab;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by jean on 05/03/17.
 */
public class TabLoader extends ArrayList<String> {
    int index = 0;

    public void load(String path) {
        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                add(line);
            }
            add(null);
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String nextLine() {
        return get(index++);
    }
}
