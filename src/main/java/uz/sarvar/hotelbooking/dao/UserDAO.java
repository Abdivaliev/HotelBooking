package uz.sarvar.hotelbooking.dao;

import uz.sarvar.hotelbooking.ConnectionSource;
import uz.sarvar.hotelbooking.model.User;
import uz.sarvar.hotelbooking.util.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {
    private ConnectionSource connection = ConnectionSource.instance();
    private static final UserDAO userDAO = new UserDAO();

    public User getUserById(Integer id) {
        User user = null;
        String query = "SELECT * FROM users WHERE id = " + id;
        try (Statement statement = connection.createConnection().createStatement();
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

    public User save(String firstName,String surname,String phoneNumber,String email) throws SQLException {
        User user = null;
        String insertQuery = " INSERT INTO users(first_name, surname, phone_number, email, role) " +
                "VALUES('" +firstName + "', '" + surname + "', '+" + phoneNumber + "', '" + email + "', '" + Role.USER.name() + "'); ";
        Statement statement = connection.createConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(insertQuery);
        while (resultSet.next()) {
            user=new User(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7)
            );
        }
        return user;
    }

    public static UserDAO getInstance() {
        return userDAO;
    }
}
