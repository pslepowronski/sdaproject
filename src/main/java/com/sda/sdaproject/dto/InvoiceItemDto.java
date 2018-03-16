package com.sda.sdaproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceItemDto {
    private Integer id;
    private Integer productId;
    private Integer quantity;
    private BigDecimal sum;
    private Integer invoiceId;
}
