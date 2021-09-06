package utils;

import java.io.FileInputStream;


public class Property {
    public java.util.Properties getProperties() {
        java.util.Properties properties = new java.util.Properties();
        try {
            String path = "src/test/resources/Config.properties";
            FileInputStream fileInputStream = new FileInputStream(path);
            properties.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    public String getProperty(String propertyKey) {
        java.util.Properties properties = getProperties();
        return properties.getProperty(propertyKey);
    }

}

