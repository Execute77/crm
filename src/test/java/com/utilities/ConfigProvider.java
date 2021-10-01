package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigProvider {

    final String configFilePath = "/src/test/resources/config.properties";
    private static Properties config;

    private void loadConfig(){
        try {
            File file = new File(System.getProperty("user.dir") + configFilePath);
            FileInputStream fileInputStream = new FileInputStream(file);
            config = new Properties();
            config.load(fileInputStream);
        }catch (Exception e){
            System.out.println("Unable to load config file - "+e);
        }
    }

    public Properties getConfig(){
        if (config == null)
            loadConfig();
        return config;
    }
}
