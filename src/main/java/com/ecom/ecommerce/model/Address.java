package com.ecom.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @NotBlank
    @Size(min = 5, message = "Street name must br atLeast 5 characters")
    private String street;

    @NotBlank
    @Size(min = 5, message = "Building name must be atLeast 5 characters")
    private String buildingName;

    @NotBlank
    @Size(min = 4, message = "City name must be atLeast 4 characters")
    private String city;

    @NotBlank
    @Size(min = 2, message = "state name must be atLeast 2 characters")
    private String state;

    @NotBlank
    @Size(min = 2, message = "Country name must be atLeast 2 characters")
    private String country;

    @NotBlank
    @Size(min = 6, message = "pin code must be atLeast 6 characters")
    private String pinCode;

    @ToString.Exclude
    @ManyToMany(mappedBy = "addresses")
    private List<User> users = new ArrayList<>();

    public Address(String street, List<User> users, String buildingName, String city,
                   String state, String country, String pinCode) {
        this.street = street;
        this.users = users;
        this.buildingName = buildingName;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pinCode = pinCode;
    }
}
