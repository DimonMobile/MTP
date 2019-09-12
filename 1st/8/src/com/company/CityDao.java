package com.company;

import java.sql.*;

public class CityDao {
    private Statement statement;

    private void checkForExistence() throws SQLException {
        ResultSet resultSet = statement.executeQuery("SHOW TABLES");
        boolean exists = false;
        while(resultSet.next()) {
            if (resultSet.getString(1).equals("city")) {
                exists = true;
                break;
            }
        }
        if (!exists) { // if table not exists then create them
            statement.execute("CREATE TABLE city(name VARCHAR(30) PRIMARY KEY, created DATE NOT NULL, square DOUBLE NOT NULL )");
        }
    }

    public CityDao(Statement statement) throws SQLException {
        this.statement = statement;
        checkForExistence();
    }

    public void addCity(String name, String created, double square) throws SQLException {
        statement.execute(String.format("INSERT INTO city(name, created, square) VALUES('%s', '%s', '%s')", name, created, square));
    }
}
