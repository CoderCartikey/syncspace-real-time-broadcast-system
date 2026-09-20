package com.syncspace.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/syncspace_db";
    private static final String USER = "root";

    private DatabaseConnection() {
    }
    public static Connection getConnection() throws SQLException {
        String password = System.getenv("SYNCSPACE_DB_PASSWORD");
    }
}
