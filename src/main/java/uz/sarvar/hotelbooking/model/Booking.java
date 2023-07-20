package uz.sarvar.hotelbooking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.sarvar.hotelbooking.util.RoomStatus;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    private Integer id;
    private RoomStatus status;
    private Integer numberOfBeds;
    private Timestamp startDate;
    private Timestamp endDate;
    private Client client;

}
