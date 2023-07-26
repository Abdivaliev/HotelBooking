package uz.sarvar.hotelbooking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.sarvar.hotelbooking.util.RoomStatus;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    private Integer id;
    private Integer price;
    private String extraInfo;
    private Room room;
    private Hotel hotel;
    private Booking booking;

    public Double getPrice() {
        double basicPrice = room.getSquare() * 1 + booking.getNumberOfBeds() * 10;
        if (booking.getStatusRoom().equals(RoomStatus.STANDARD.name())) {
            return basicPrice;
        } else if (booking.getStatusRoom().equals(RoomStatus.DELUXE.name())) {
            return 1.5 * basicPrice;
        } else if (booking.getStatusRoom().equals(RoomStatus.PREMIUM.name())) {
            return 2 * basicPrice;
        }
        return 0d;
    }

}
