package uz.sarvar.hotelbooking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.sarvar.hotelbooking.util.RoomStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Room {
    private Integer id;
    private boolean balcony;
    private String extra;
    private boolean isBooked;
    private Integer numberOfBeds;
    private RoomStatus status;
    private Integer square;
    private Integer numberOfRooms;
}
