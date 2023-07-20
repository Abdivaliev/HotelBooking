package uz.sarvar.hotelbooking.model.price;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriceByStatus {
    private String typeOfStatus;
    private Integer price;
}
