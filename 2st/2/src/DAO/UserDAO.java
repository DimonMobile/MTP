package DAO;

import models.Card;
import models.User;

import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO {
    private Connection connection;
    private String databaseAddress = "192.168.43.111";

    public UserDAO() throws Exception {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://" + databaseAddress + "/Univer_java_lab2?user=root&password=12345678");
    }

    public User getUser(int id) throws Exception {
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM User WHERE id=" + String.valueOf(id));
        if (rs.first()) {
            User newUser = new User();
            newUser.setId(id);
            newUser.setName(rs.getString("name"));
            newUser.setPassword(rs.getString("password"));

            Card newCard = new Card();
            newCard.setCvc(rs.getInt("card_cvc"));
            newCard.setNum(rs.getString("card_num"));
            newCard.setUntil(rs.getDate("card_until"));
            newCard.setSum(rs.getInt("card_sum"));

            newUser.setCard(newCard);

            return newUser;
        }
        return null;
    }

    public void updateUser(User user) throws Exception {
        Statement st = connection.createStatement();
        Card card = user.getCard();
        st.executeUpdate("UPDATE User SET name=\"" + user.getName() + "\", password=\""
                + user.getPassword() + "\", card_cvc=" + card.getCvc() + ", card_num=\"" + card.getNum() + "\", card_until=\""
                + card.getUntil().toString() + "\", card_sum=" + card.getSum());

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
