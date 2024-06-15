package br.com.fintech.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    
    // Static block to register the JDBC driver
    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to load SQL Server JDBC driver", e);
        }
    }
    
    private static final String URL = "jdbc:sqlserver://ETRINDNBT16:49152;instanceName=SQLEXPRESS;encrypt=true;trustServerCertificate=true;databaseName=FIAP_Fintech";
    private static final String USER = "sa";
    private static final String PASSWORD = "P@ssw0rd";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
