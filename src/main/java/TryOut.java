import sun.lwawt.macosx.CSystemTray;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class TryOut {
    public static void main(String[] args) {

        final String configFilePath = "/src/test/resources/config.properties";
        Properties config = null;
        
        try {
            File file = new File(System.getProperty("user.dir") + configFilePath);
            FileInputStream fileInputStream = new FileInputStream(file);
            config = new Properties();
            config.load(fileInputStream);
        }catch (Exception e){
            System.out.println("Unable to load config file - "+e);
        }

        System.out.println(config.getProperty("browser"));
    }
}
