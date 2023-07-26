package uz.sarvar.hotelbooking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.sarvar.hotelbooking.util.RoomStatus;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    private Integer id;
    private String extraInfo;
    private double price;
    private Room room;
    private Hotel hotel;
    private Booking booking;

    public Double getPrice() {
        long days = ChronoUnit.DAYS.between(booking.getStartDate(), booking.getEndDate());
        return (double) (room.getPrice() * days);

    }

    public Reservation(String extraInfo, Room room, Hotel hotel, Booking booking) {
        this.extraInfo = extraInfo;
        this.room = room;
        this.hotel = hotel;
        this.booking = booking;
    }
}
