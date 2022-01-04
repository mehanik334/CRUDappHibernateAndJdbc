package com.denisenko.crudNew.utils;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPoolDB {

    private static BasicDataSource dataSource = new BasicDataSource();

    static {
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(PropertiesDB.getProperties().get(0));
        dataSource.setUsername(PropertiesDB.getProperties().get(1));
        dataSource.setPassword(PropertiesDB.getProperties().get(2));
    }

    private ConnectionPoolDB(){}

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

}
