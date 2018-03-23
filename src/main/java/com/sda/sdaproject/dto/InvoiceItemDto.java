package com.sda.sdaproject.dto;

import com.sda.sdaproject.entity.Invoice;
import com.sda.sdaproject.entity.Product;
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
    private Product product;
    private Integer quantity;
    private BigDecimal sum;
    private Invoice invoice;

}
