package com.utilities;

import java.util.Properties;

public class ConfigFactory {

    Properties config;

    public ConfigFactory() {
        config = new ConfigProvider().getConfig();
    }

    public String getBrowser(){
        return config.getProperty("browser");
    }

    public String getURL(){
        return config.getProperty("url");
    }
}
