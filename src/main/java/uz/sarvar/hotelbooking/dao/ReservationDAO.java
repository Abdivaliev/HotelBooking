package uz.sarvar.hotelbooking.dao;

import uz.sarvar.hotelbooking.ConnectionSource;
import uz.sarvar.hotelbooking.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {
    private static final ReservationDAO reservationDAO = new ReservationDAO();
    private ConnectionSource connection = ConnectionSource.instance();
    private BookingDAO bookingDAO = BookingDAO.getInstance();
    private RoomDAO roomDAO = RoomDAO.getInstance();
    private HotelDAO hotelDAO = HotelDAO.getInstance();


    public List<Reservation> getAllReservation() {
        List<Reservation> reservations = new ArrayList<>();
        String query = "SELECT * FROM reservation";
        try (Statement statement = connection.createConnection().createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            while (rs.next()) {
                Reservation reservation = new Reservation(
                       rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        roomDAO.getRoomById(rs.getInt(5)),
                        hotelDAO.getHotelInfo(),
                        bookingDAO.getBookingById(rs.getInt(6))
                );
                reservations.add(reservation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }

    public boolean reserved(String bookingId, String roomNumber) throws SQLException {
        Integer bookedNum = Integer.valueOf(bookingId);
        Integer roomNum = Integer.valueOf(roomNumber);

        Hotel hotelInfo = hotelDAO.getHotelInfo();
        Room roomByNumber = roomDAO.getRoomByNumber(roomNum);
        Booking bookingById = bookingDAO.getBookingById(bookedNum);
        Reservation reservation = new Reservation(
                "Have a good day",
                roomByNumber,
                hotelInfo,
                bookingById
        );

        Double price = reservation.getPrice();
        Statement statement = connection.createConnection().createStatement();
        int executed = statement.executeUpdate("insert into reservation(price,extra_info, hotel_id, room_id, booking_id) " +
                "VALUES ('" + price + "','" + reservation.getExtraInfo() + "','" + hotelInfo.getId() + "','" + roomByNumber.getId() + "','" + bookingById.getId() + "');");
        if (executed > 0) {
            bookingDAO.delete(bookedNum);
            roomDAO.bookedRoom(roomNum);
            return true;
        }
        return false;
    }

    public static ReservationDAO getInstance() {
        return reservationDAO;
    }

}
