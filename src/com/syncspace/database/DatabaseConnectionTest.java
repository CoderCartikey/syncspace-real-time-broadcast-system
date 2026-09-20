package com.syncspace.database;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnectionTest {
    public static void main(String[] args) {
        try(Connection connection = DatabaseConnection.getConnection()){
            System.out.println("Database connection established");
        } catch (SQLException | IllegalStateException e) {
            System.out.println("Database connection establishment failed: " + e.getMessage());
        }
    }
}
