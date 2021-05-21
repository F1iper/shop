package pl.shop.models;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class CustomerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    @OneToOne
    @MapsId
    private Customer customer;

    private String phone;

    private String email;

    private String streetName;

    private String streetNumber;

    private String houseNumber;

    private String postalCode;

    private String City;
}
