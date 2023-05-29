package org.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Driver {

    public void connect() {
        try {
            String url = "jdbc:postgresql://localhost/dbproj";
            String user = "mb14";
            String password = "tianay";
            DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.connect();
    }
}