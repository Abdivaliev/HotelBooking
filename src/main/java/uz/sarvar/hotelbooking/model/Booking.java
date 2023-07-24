package uz.sarvar.hotelbooking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    private Integer id;
    private String statusRoom;
    private Integer numberOfBeds;
    private LocalDate startDate;
    private LocalDate endDate;
    private User client;
}
