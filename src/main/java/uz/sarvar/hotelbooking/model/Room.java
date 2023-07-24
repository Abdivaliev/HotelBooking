package uz.sarvar.hotelbooking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.sarvar.hotelbooking.util.RoomStatus;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Room {
    private Integer id;
    private boolean balcony;
    private String extra;
    private boolean isBooked=false;
    private Integer numberOfBeds;
    private String status;
    private BigDecimal square;
    private Integer numberOfRooms;
    private Integer roomNumber;
    private String photoLink;
}
