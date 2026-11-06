
package com.webtech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/5thSemWebTechLab";

    private static final String USER = "root";

    private static final String PASSWORD = "Arpan@123";

    public static Connection getConnection()
            throws SQLException {

        try {
            // Explicitly load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            return DriverManager.getConnection(
                    URL, USER, PASSWORD);

        } catch (ClassNotFoundException e) {

            throw new SQLException(
                    "MySQL JDBC Driver class not found!", e);
        }
    }
}
