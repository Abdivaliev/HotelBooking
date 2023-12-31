package uz.sarvar.hotelbooking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
    private Integer id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String photoLink;
    private String description;
}
