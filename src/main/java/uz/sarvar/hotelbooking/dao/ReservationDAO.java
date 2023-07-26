package uz.sarvar.hotelbooking.dao;

import uz.sarvar.hotelbooking.ConnectionSource;
import uz.sarvar.hotelbooking.model.Reservation;

public class ReservationDAO {
    private static final ReservationDAO reservationDAO = new ReservationDAO();
    private ConnectionSource connectionSource = ConnectionSource.instance();

    public int reserved(String bookingId, String roomNumber) {
        Integer bookedNum = Integer.valueOf(bookingId);
        Integer roomNum = Integer.valueOf(roomNumber);
        Reservation reservation = new Reservation();
        return 0;
    }

    public static ReservationDAO getInstance() {
        return reservationDAO;
    }

}
