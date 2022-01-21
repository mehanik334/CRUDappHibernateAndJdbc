package com.denisenko.crudNew.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class PropertiesDB {

    public static ArrayList<String> getProperties() {
        ArrayList<String> listProperties = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\meha3\\IdeaProjects\\CRUDappNew\\src\\main\\resources\\app.properties");
            Properties properties = new Properties();
            properties.load(fileInputStream);

            listProperties.add(properties.getProperty("db.url"));
            listProperties.add(properties.getProperty("db.login"));
            listProperties.add(properties.getProperty("db.password"));
            listProperties.add(properties.getProperty("driver.class.name"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return listProperties;
    }
}
