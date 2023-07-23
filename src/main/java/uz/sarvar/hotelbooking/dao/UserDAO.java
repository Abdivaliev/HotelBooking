package uz.sarvar.hotelbooking.dao;

import uz.sarvar.hotelbooking.model.User;
import uz.sarvar.hotelbooking.util.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {
    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public User getUserById(Integer id) {
        User user = null;
        String query = "SELECT * FROM users WHERE id = " + id;
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("first_name"));
                user.setSurname(rs.getString("surname"));
                user.setPhoneNumber(rs.getString("phone_number"));
                user.setEmail(rs.getString("email"));
                user.setRole(Role.USER.name());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

}
