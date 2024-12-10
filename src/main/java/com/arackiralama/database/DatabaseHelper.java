package com.arackiralama.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHelper {
    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;database=AracKiralamaDB;encrypt=true;trustServerCertificate=true;";
    private static final String DB_USER = "Javauser";
    private static final String DB_PASSWORD = "java12345";

    public static Connection getConnection() throws SQLException {
        try {
            // SQL Server JDBC Driver'ının yüklendiğinden emin ol
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("SQL Server JDBC Driver bulunamadı!");
            e.printStackTrace();
        }
        // Veritabanı bağlantısını oluştur
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    // Bağlantıyı kapatmak için yardımcı metod
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Bağlantı kapatılamadı!");
                e.printStackTrace();
            }
        }
    }
}
