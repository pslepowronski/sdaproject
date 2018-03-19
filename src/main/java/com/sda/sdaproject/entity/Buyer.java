package com.sda.sdaproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "buyer")
public class Buyer {

    @Id
    @GeneratedValue
    private Integer id;

    private String firstName;

    private String lastName;

    private String companyName;

    private String taxNumber;

    private String street;

    private String streetNumber;

    private String city;

    private String postcode;
}
