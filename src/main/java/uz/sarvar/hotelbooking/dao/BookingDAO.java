package uz.sarvar.hotelbooking.dao;

import uz.sarvar.hotelbooking.ConnectionSource;
import uz.sarvar.hotelbooking.model.Booking;
import uz.sarvar.hotelbooking.model.Room;
import uz.sarvar.hotelbooking.model.User;
import uz.sarvar.hotelbooking.util.RoomStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {
    private Connection connection;
    private UserDAO userDAO = new UserDAO(ConnectionSource.instance().createConnection());

    public BookingDAO(Connection connection) throws SQLException {
        this.connection = connection;
    }

    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT * FROM booking";
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            while (rs.next()) {
                Booking booking = new Booking();
                booking.setId(rs.getInt("id"));
                booking.setStatus(String.valueOf(RoomStatus.valueOf(rs.getString("status"))));
                booking.setNumberOfBeds(rs.getInt("number_of_beds"));
                booking.setStartDate(rs.getTimestamp("start_date"));
                booking.setEndDate(rs.getTimestamp("end_date"));
                // Assuming UserDAO has a method to get a User by id
                User client = userDAO.getUserById(rs.getInt("client_id"));
                booking.setClient(client);
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }

}
