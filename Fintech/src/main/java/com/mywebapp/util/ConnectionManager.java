package com.mywebapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String URL = "jdbc:sqlserver://localhost;databaseName=FIAP_Fintech";
    private static final String USER = "sa";
    private static final String PASSWORD = "P@ssw0rd";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
