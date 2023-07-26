package uz.sarvar.hotelbooking.model.dto;

import lombok.Getter;
import uz.sarvar.hotelbooking.model.Reservation;

@Getter
public class ReservationDTO {
    private double price;
    private Reservation reservation;
}
