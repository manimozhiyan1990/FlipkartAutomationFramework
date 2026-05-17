package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static Properties prop;

    public ConfigReader() throws IOException {
        prop = new Properties();
        FileInputStream f = new FileInputStream("src/test/resources/config/config.properties");
        prop.load(f);
    }
    public String getBrowser(){
       return prop.getProperty("browser");

    }
    public  String getUrl(){
       return prop.getProperty("url");
    }
    public int getImplicitWait() {
        return Integer.parseInt(prop.getProperty("implicitWait"));
    }

    public int getExplicitWait() {
        return Integer.parseInt(prop.getProperty("explicitWait"));
    }
}
