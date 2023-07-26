package uz.sarvar.hotelbooking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.sarvar.hotelbooking.util.RoomStatus;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;

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
    private String statusOfRoom;
    private Double square;
    private Integer numberOfRooms;
    private Integer roomNumber;
    private String photoLink;

    public int getPrice() {
        double basicPrice = square * 1 + numberOfBeds * 10 ;
        if (statusOfRoom.equals(RoomStatus.STANDARD.name())) {
            return (int) basicPrice;
        } else if (statusOfRoom.equals(RoomStatus.DELUXE.name())) {
            return (int) (1.5 * basicPrice);
        } else if (statusOfRoom.equals(RoomStatus.PREMIUM.name())) {
            return (int) (2 * basicPrice);
        }
        return 0;
    }

}
