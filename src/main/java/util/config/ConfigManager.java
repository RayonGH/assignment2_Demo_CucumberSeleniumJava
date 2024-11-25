package util.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager extends ConfigConstants {

    private InputStream inputStream;
    protected Properties prop = new Properties();
    private static final ThreadLocal<String> propFileNames = new ThreadLocal<>();

    public ConfigManager() {
        try {
            propFileNames.set("config.properties");
            inputStream = getClass().getClassLoader()
                    .getResourceAsStream(propFileNames.get());

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileNames.get() + "' not found in the classpath");
            }

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            try {
                assert inputStream != null;
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}