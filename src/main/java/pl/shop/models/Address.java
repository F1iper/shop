package pl.shop.models;

import lombok.*;

import javax.persistence.*;

@Embeddable
public class Address {

    private String streetName;

    private String streetNumber;

    private String houseNumber;

    private String postalCode;

    private String city;
}
