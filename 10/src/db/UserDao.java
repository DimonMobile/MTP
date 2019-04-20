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
            statement.execute("CREATE TABLE users(email VARCHAR(50), password VARCHAR(256) NOT NULL, CONSTRAINT users_pk PRIMARY KEY users(email)");
        }
    }
}
