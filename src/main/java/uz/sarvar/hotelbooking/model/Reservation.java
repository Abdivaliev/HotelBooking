package uz.sarvar.hotelbooking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private LocalDate startDate;
    private LocalDate endDate;
    private String clientName;
    private Integer roomNumber;
    private Hotel hotel;
    private String extraInfo;
    private Booking booking;
}
