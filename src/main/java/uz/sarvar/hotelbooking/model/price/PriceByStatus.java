package uz.sarvar.hotelbooking.model.price;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.sarvar.hotelbooking.util.RoomStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriceByStatus {
    private RoomStatus typeOfStatus;
    private Integer price;
}
