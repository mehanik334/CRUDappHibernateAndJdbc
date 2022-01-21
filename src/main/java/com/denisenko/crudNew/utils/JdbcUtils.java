package com.denisenko.crudNew.utils;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcUtils {

    private static BasicDataSource dataSource = new BasicDataSource();

    static {
        dataSource.setDriverClassName(PropertiesDB.getProperties().get(3));
        dataSource.setUrl(PropertiesDB.getProperties().get(0));
        dataSource.setUsername(PropertiesDB.getProperties().get(1));
        dataSource.setPassword(PropertiesDB.getProperties().get(2));
    }

    private JdbcUtils(){}

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static PreparedStatement getPrepareStatement(String sqlQuery) {
        try {
            return getConnection().prepareStatement(sqlQuery);
        } catch (SQLException e) {
            return null;
        }
    }
}
