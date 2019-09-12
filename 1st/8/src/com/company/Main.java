package com.company;

import java.sql.*;

public class Main {

    private static void addCities(CityDao cityDao) throws SQLException {
        cityDao.addCity("Bobruisk", "1565.07.05", 1234);
        cityDao.addCity("Borisov", "1102.07.05", 1234);
        cityDao.addCity("Vitebsk", "974.07.05", 1234);
        cityDao.addCity("Gorki", "1544.07.05", 1234);
    }

    private static void addPopulations(PopulationDao populationDao) throws SQLException {
        populationDao.addPopulation("Ha4i", "Bobruisk", "Ahabskiy");
        populationDao.addPopulation("Kabani", "Bobruisk", "Kazahskiy");
        populationDao.addPopulation("4urki", "Gorki", "English");
        populationDao.addPopulation("Lukashi", "Vitebsk", "Helbskiy");
    }

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/univer", "root", "12345678");
            Statement statement = connection.createStatement();

            CityDao cityDao = new CityDao(statement);
            PopulationDao populationDao = new PopulationDao(statement);

            //addCities(cityDao);
            //addPopulations(populationDao);

            populationDao.printAbout("Kazahskiy", "Bobruisk");

        } catch(ClassNotFoundException e) {
            System.out.println("Driver not found!");
        } catch(SQLException e) {
            System.out.println(e);
        }
    }
}
