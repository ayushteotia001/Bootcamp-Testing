package com.saucedemo.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    Properties properties;

    public ConfigReader() {
        properties = new Properties();
        try {

            FileInputStream fis =
                    new FileInputStream("src/main/resources/config.properties");
            
            properties.load(fis);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getBrowser() {

        return properties.getProperty("browser");
    }

    public String getUrl() {

        return properties.getProperty("url");
    }

    public String getUsername() {

        return properties.getProperty("username");
    }

    public String getPassword() {

        return properties.getProperty("password");
    }

}