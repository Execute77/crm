package com.utilities;

import org.testng.annotations.Parameters;

import java.util.Properties;

public class ConfigFactory {

    Properties config;

    public ConfigFactory() {
        config = new ConfigProvider().getConfig();
    }

    public String getBrowser(){
        if(System.getProperty("browserFromMaven") == null)
            return config.getProperty("browser");
        return System.getProperty("browserFromMaven");
    }

    public String getURL(){
        if(System.getProperty("urlToBeTested") == null)
            return config.getProperty("url");
        return System.getProperty("urlToBeTested");
    }

}
