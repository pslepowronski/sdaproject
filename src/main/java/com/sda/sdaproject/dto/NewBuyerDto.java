package com.sda.sdaproject.dto;

import lombok.*;

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class NewBuyerDto {

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


