package uz.sarvar.hotelbooking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Check {
    private Integer id;
    private Integer price;
    private Timestamp startDate;
    private Timestamp endDate;
    private String clientName;
    private List<Room> rooms;
    private Hotel hotel;
    private String extraInfo;

}
