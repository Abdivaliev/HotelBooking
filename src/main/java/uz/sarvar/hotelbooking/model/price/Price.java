package uz.sarvar.hotelbooking.model.price;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Price {
    private Integer basicPrice;
    private List<PriceByStatus> priceByStatus;
    private List<PriceBySquare> priceBySquare;
    private List<PriceByEachBed> priceByEachBed;
}
