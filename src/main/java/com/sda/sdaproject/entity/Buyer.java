package com.sda.sdaproject.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "buyer")
public class Buyer {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "tax_number")
    private String taxNumber;

    private String street;

    @Column(name = "street_number")
    private String streetNumber;

    private String city;

    private String postcode;
}
