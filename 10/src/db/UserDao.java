package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {
    public UserDao() throws ClassNotFoundException, SQLException {
        Statement statement = DatabaseConnection.getStatement();
        ResultSet resultSet = statement.executeQuery("SHOW TABLES");
        boolean exists = false;
        while(resultSet.next()) {
            if (resultSet.getString(1).equals("users")) {
                exists = true;
                break;
            }
        }
        if (!exists) {
            statement.execute("CREATE TABLE users(email VARCHAR(50), password VARCHAR(256) NOT NULL, CONSTRAINT users_pk PRIMARY KEY users(email))");
        }
    }

    public boolean isExists(String email) throws SQLException, ClassNotFoundException{
        Statement statement = DatabaseConnection.getStatement();
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(email) FROM users WHERE email='" + email + "'");
        resultSet.next();
        if (resultSet.getInt(1) == 1){
            return true;
        } else {
            return false;
        }
    }

    public void addUser(String email, String password) throws SQLException, ClassNotFoundException {
        Statement statement = DatabaseConnection.getStatement();
        statement.execute("INSERT INTO users(email, password) VALUES('" + email + "','" + password + "')");
    }

    public boolean checkFor(String email, String password) throws SQLException, ClassNotFoundException {
        Statement statement = DatabaseConnection.getStatement();
        ResultSet resultSet = statement.executeQuery("SELECT password FROM users WHERE email='" + email +"'");
        if (resultSet.next()) {
            String retrievedPassword = resultSet.getString(1);
            if (retrievedPassword.equals(password)) {
                return true;
            }
        }
        return false;
    }
}
