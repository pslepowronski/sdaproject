package com.sda.sdaproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuyerDto {
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
