package gui;

import java.io.*;
import java.util.Properties;

/**
 * Created by jean on 05/03/17.
 */
public class DrummerProperties {
    public static String getProperty(String key) {
        Properties properties = new Properties();
        try {
            InputStream inputStream = new FileInputStream("conf.properties");
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }

    public static void saveProperty(String key, String value) {
        Properties properties = new Properties();
        try {
            InputStream inputStream = new FileInputStream("conf.properties");
            properties.load(inputStream);
            properties.setProperty(key, value);
            inputStream.close();
            OutputStream outputStream = new FileOutputStream("conf.properties");
            properties.store(outputStream, null);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
