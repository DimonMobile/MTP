package com.company;

import java.sql.*;

public class PopulationDao {
    private Statement statement;

    private void checkForExistence() throws SQLException {
        ResultSet resultSet = statement.executeQuery("SHOW TABLES");
        boolean exists = false;
        while(resultSet.next()) {
            if (resultSet.getString(1).equals("population")) {
                exists = true;
                break;
            }
        }
        if (!exists) { // if table not exists then create them
            statement.execute("CREATE TABLE population(name VARCHAR(30) PRIMARY KEY, city VARCHAR(30), language VARCHAR(30) NOT NULL, FOREIGN KEY (city) REFERENCES city(name))");
        }
    }

    public PopulationDao(Statement statement) throws SQLException {
        this.statement = statement;
        checkForExistence();
    }

    public void addPopulation(String name, String city, String language) throws SQLException {
        statement.execute(String.format("INSERT INTO population(name, city, language) VALUES('%s', '%s', '%s')", name, city, language));
    }

    public void printAbout(String language, String city) throws SQLException{
        ResultSet resultSet = statement.executeQuery("SELECT * FROM population WHERE language='" + language + "' AND city='" + city + "'");
        while(resultSet.next()) {
            System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
        }
    }
}
