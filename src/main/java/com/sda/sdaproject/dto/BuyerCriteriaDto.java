package com.sda.sdaproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BuyerCriteriaDto {

    private String firstName;
    private String lastName;
    private String companyName;
    private String taxNumber;
    private String city;
}
