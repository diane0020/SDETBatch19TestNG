package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static String read(String key) {
        try {
            FileInputStream fis = new FileInputStream(Constants.CONFIG_FILE_PATH);
            Properties properties = new Properties();
            properties.load(fis);
            return properties.getProperty(key);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
