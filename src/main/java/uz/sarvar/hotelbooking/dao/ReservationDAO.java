package uz.sarvar.hotelbooking.dao;

import uz.sarvar.hotelbooking.ConnectionSource;
import uz.sarvar.hotelbooking.model.Booking;
import uz.sarvar.hotelbooking.model.Hotel;
import uz.sarvar.hotelbooking.model.Reservation;
import uz.sarvar.hotelbooking.model.Room;

import java.sql.SQLException;
import java.sql.Statement;

public class ReservationDAO {
    private static final ReservationDAO reservationDAO = new ReservationDAO();
    private ConnectionSource connectionSource = ConnectionSource.instance();
    private BookingDAO bookingDAO = BookingDAO.getInstance();
    private RoomDAO roomDAO = RoomDAO.getInstance();
    private HotelDAO hotelDAO = HotelDAO.getInstance();

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
        Statement statement = connectionSource.createConnection().createStatement();
        int executed = statement.executeUpdate("insert into reservation(extra_info, hotel_id, room_id, booking_id) " +
                "VALUES ('" + reservation.getExtraInfo() + "','" + hotelInfo.getId() + "','" + roomByNumber.getId() + "','" + bookingById.getId() + "');");
        if (executed > 0) {
            bookingDAO.delete(bookedNum);
            return true;
        }
        return false;
    }

    public static ReservationDAO getInstance() {
        return reservationDAO;
    }

}
