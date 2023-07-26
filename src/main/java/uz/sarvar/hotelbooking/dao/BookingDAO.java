package uz.sarvar.hotelbooking.dao;

import uz.sarvar.hotelbooking.ConnectionSource;
import uz.sarvar.hotelbooking.model.Booking;
import uz.sarvar.hotelbooking.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {
    private ConnectionSource connection = ConnectionSource.instance();
    private UserDAO userDAO = UserDAO.getInstance();

    private static final BookingDAO bookingDAO = new BookingDAO();


    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT * FROM booking";
        try (Statement statement = connection.createConnection().createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            while (rs.next()) {
                Booking booking = new Booking();
                booking.setId(rs.getInt("id"));
                booking.setStatusRoom(rs.getString("status_room"));
                booking.setNumberOfBeds(rs.getInt("number_of_beds"));
                booking.setStartDate(rs.getDate("start_date").toLocalDate());
                booking.setEndDate(rs.getDate("end_date").toLocalDate());
                User client = userDAO.getUserById(rs.getInt("client_id"));
                booking.setClient(client);
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    public int save(String statusRoom, String numberOfBeds, String startDate, String endDate, String firstName, String surname, String phoneNumber, String email) throws SQLException {
        User user = userDAO.save(firstName, surname, phoneNumber, email);
        System.out.println(startDate);
        System.out.println(endDate);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd");
        int numOfBeds = Integer.parseInt(numberOfBeds);
        LocalDate from = LocalDate.parse(startDate, formatter);
        LocalDate to = LocalDate.parse(endDate, formatter);

        String insertBookingQuery = "insert into booking (status_room, number_of_beds, start_date, end_date, client_id) " +
                "values ('" + statusRoom + "','" + numOfBeds + "','" + from + "','" + to + "'," + user.getId() + ");";

        if (user != null) {
            Statement statement = connection.createConnection().createStatement();
            return statement.executeUpdate(insertBookingQuery);

        }
        return 0;
    }

    public static BookingDAO getInstance() {
        return bookingDAO;
    }
}
