package uz.sarvar.hotelbooking;

import uz.sarvar.hotelbooking.dao.BookingDAO;
import uz.sarvar.hotelbooking.dao.RoomDAO;
import uz.sarvar.hotelbooking.model.Booking;
import uz.sarvar.hotelbooking.model.Room;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        BookingDAO roomDAO=new BookingDAO(ConnectionSource.instance().createConnection());
        List<Booking> bookings = roomDAO.getAllBookings();
        for (Booking booking : bookings) {
            System.out.println(booking.getStatus());
        }
    }
}
