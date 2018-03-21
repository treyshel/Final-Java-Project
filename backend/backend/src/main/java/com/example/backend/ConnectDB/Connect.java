package com.example.backend;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    public static Connection connectDB() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql:on-belay-db", "treyshel", "localpass");
    }
}

