package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO {
    private Connection connection;

    public UserDAO() throws Exception {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://localhost?user=root&password=12345678");
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SHOW DATABASES");
        System.out.println(rs.toString());
    }
}
