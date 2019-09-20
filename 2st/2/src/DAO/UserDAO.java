package DAO;

import models.User;

import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Base64;

public class UserDAO {
    private Connection connection;

    public UserDAO() throws Exception {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://localhost/Univer_java_lab2?user=root&password=12345678");
    }

    public int checkCredentials(User user) throws Exception{
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM User WHERE name=\"" + user.getName() +"\"");
        if (rs.first()) {
            if (rs.getString("password").equals(sha256(user.getPassword()))) {
                return rs.getInt("id");
            }
        }
        return -1;
    }

    private String sha256(String source) {
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(source.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
