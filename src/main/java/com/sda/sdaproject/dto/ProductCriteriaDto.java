package com.sda.sdaproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCriteriaDto {
    private String name;
    private BigDecimal priceFrom;
    private BigDecimal priceTo;
    private Integer quantityFrom;
    private Integer quantityTo;
}
