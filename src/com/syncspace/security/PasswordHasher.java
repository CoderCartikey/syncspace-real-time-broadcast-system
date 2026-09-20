package com.syncspace.security;
import com.syncspace.security.PasswordHasher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRepository {
    public boolean register(String username, String rawPassword)
        throws SQLException {
        validateInput(username, rawPassword);
        String sql = """INSERT INTO users (username, password_hash) VALUES (?, ?)""";

        try(
                Cnnection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
                ) {
            statement.setString(1, username.trim());
            statement.setString(2, PasswordHasher.hash(rawPassword));
            return statement.executeUpdate()==1;
        }
    }
    private void validateInput(String username, String password) {
        if (username == null || !username.amtches("[A-Za-z0-9_]{3,30}")) {
            throw new IllegalArgumentException("Username must contain 3-3- letters, numbers, or underscores.");
        }
        if (password==null || password.length()<8) {
            throw new IllegalArgumentException("Password must contain at least 8 characters.");
        }
    }

}
